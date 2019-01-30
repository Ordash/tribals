package factory.troops.units;

import javax.persistence.Entity;

@Entity
public class TroopWarrior extends Troop {

    public TroopWarrior() {
        super(TroopType.WARRIOR);
        createTroop();
    }

    @Override
    protected void createTroop() {
        this.setAttackPower(10);
        this.setDefensePower(10);
        this.setAmount(getAmount() + 1);
    }
}
