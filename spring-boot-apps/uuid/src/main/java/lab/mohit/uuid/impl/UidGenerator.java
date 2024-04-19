package lab.mohit.uuid.impl;

import lab.mohit.uuid.IUidGenerator;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UidGenerator implements IUidGenerator {

    private static final int TIMESTAMP_BITS = 41;
    private static final int DATA_CENTER_ID_BITS = 5;
    private static final int NODE_ID_BITS = 5;
    private static final int SEQUENCE_BITS = 12;

    private static final long EPOCH_MILLIS = 1708387200000L; // "2024-02-20"
    private static final int MAX_SEQUENCE = (1 << SEQUENCE_BITS) - 1;
    private volatile int sequenceNumber = 0;
    private volatile long lastMillisWithEpochReference = -1L;

    private final long dataCenterId;
    private final long nodeId;

    public UidGenerator() {
        this.dataCenterId = 1;
        this. nodeId = 1;
    }
    public UidGenerator(int dataCenterId, int nodeId) {
        this.dataCenterId = dataCenterId;
        this.nodeId = nodeId;
    }


    @Override
    public long getUid() {
        return getNextUid();
    }

    private synchronized long getNextUid() {
        long currentMillisWithEpochReference = getCurrentMillisWithEpochReference();
        if (currentMillisWithEpochReference < lastMillisWithEpochReference) {
            // TODO: NTP health check should be used
            throw new IllegalStateException("Clock is out of sync");
        }
        if (currentMillisWithEpochReference == lastMillisWithEpochReference) {
            sequenceNumber = (sequenceNumber + 1) & MAX_SEQUENCE;
            if (sequenceNumber == 0) {
                while (currentMillisWithEpochReference == lastMillisWithEpochReference) { // Thread sleep will have performance penalty
                    currentMillisWithEpochReference = getCurrentMillisWithEpochReference();
                }
            }
        } else {
            lastMillisWithEpochReference = currentMillisWithEpochReference;
            sequenceNumber = 0;
        }

        return currentMillisWithEpochReference << (DATA_CENTER_ID_BITS + NODE_ID_BITS + SEQUENCE_BITS)
                | dataCenterId << (NODE_ID_BITS + SEQUENCE_BITS)
                | nodeId << (SEQUENCE_BITS)
                | sequenceNumber;
    }

    private long getCurrentMillisWithEpochReference() {
        return Instant.now().toEpochMilli() - EPOCH_MILLIS;
    }

}
