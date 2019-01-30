package factory.troops.units;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public abstract class Troop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long troopId;

    @Enumerated(EnumType.STRING)
    private TroopType type;

 //   private String troopTypo;
    private Integer attackPower ;
    private Integer defensePower;
    private Integer amount = 0;

    public Troop(TroopType type) {
        this.type = type;
    }


    protected abstract void createTroop();
}
