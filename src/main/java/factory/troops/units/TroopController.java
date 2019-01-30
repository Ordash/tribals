package factory.troops.units;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static factory.troops.units.TroopFactory.troopFactory;
import static factory.troops.units.TroopType.GUARD;
import static factory.troops.units.TroopType.WARRIOR;

@RestController
public class TroopController {

    private TroopRepository troopRepository;

    @Autowired
    public TroopController(TroopRepository troopRepository) {
        this.troopRepository = troopRepository;
    }

    @PostMapping("/troop")
    public void saveTroop(@RequestBody TroopDTO troopDTO) {
        if (troopDTO.getName().equals("Warrior")) {
            Troop test = new TroopWarrior();
            troopRepository.save(test);
        } else if(troopDTO.getName().equals("Guard")){
            Troop test = new TroopGuard();
            troopRepository.save(test);
        } else{
            System.out.println("noob");
        }
    }
    @GetMapping("/")
    public List<Troop> troopList() {
        return (List<Troop>) troopRepository.findAll();
    }

    @PostMapping("/enum")
    public void addTroop(@RequestBody TroopDTO troopDTO) {
        if(TroopType.valueOf(troopDTO.getName().toUpperCase()) == TroopType.GUARD) {
            troopRepository.save(GUARD.creatingTroop());
//            Troop enumTest = new TroopGuard();
//            troopRepository.save(enumTest);
        } else if(TroopType.valueOf(troopDTO.getName().toUpperCase()) == WARRIOR) {
            troopRepository.save(WARRIOR.creatingTroop());
//            Troop enumTest = new TroopWarrior();
//            troopRepository.save(enumTest);
        } else {
            System.out.println("noob");
        }
    }

    @PostMapping("/forenum")
    public void findAndAddTroop(@RequestBody TroopDTO troopDTO) {
        for (TroopType types : TroopType.values()) {
            if (TroopType.valueOf(troopDTO.getName().toUpperCase()).equals(types)){
                troopRepository.save(troopFactory(types));
            }
        }
    }
}
