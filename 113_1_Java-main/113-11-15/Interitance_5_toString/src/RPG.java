public class RPG {
        static void demoSwordMan() {
            SwordsMan swordsMan = new SwordsMan();
            swordsMan.setName("Justin");
            swordsMan.setLevel(1);
            swordsMan.setBlood(200);

            System.out.println(swordsMan);
            swordsMan.fight();


    }
    static  void demoMagician(){
        Mafician magician = new Magician();
        magician.setName("Monica");
        magician.setLevel(1);
        magician.setBlood(100);

        System.out.println(magician);

    }


    static void drawName(Role role) {
        System.out.print(role.getName());
        role.fight();
    }
}