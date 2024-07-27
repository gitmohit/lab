package lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor
public class ExchangeStock {
    public String id;
    public String name;
    public double price;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExchangeStock)) {
            return false;
        }
        ExchangeStock that = (ExchangeStock) o;
        return this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    public void update(List<ExchangeStock> stocks) {

    }
}
