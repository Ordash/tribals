package factory.troops.units;

import javax.persistence.Entity;

@Entity
public class TroopGuard extends Troop {

    public TroopGuard() {
        super(TroopType.GUARD);
        createTroop();
    }

    @Override
    protected void createTroop() {
        this.setAttackPower(10);
        this.setDefensePower(20);
        this.setAmount(getAmount() + 1);

    }
}
