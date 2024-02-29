import actions.toactionable.ItemAction;
import actions.toactionable.ItemSay;
import actions.topersons.*;
import enums.Material;
import enums.TypeOfTravel;
import interfaces.Actionable;
import real.objects.Place;
import real.objects.Person;
import real.objects.items.*;
import system.InvokeMethod;

public class Main {
    public static void main(String[] args) {

        //Places pull

        Place office = new Place("Контора");
        Place grizzleOffice = new Place("Кабинет Гризла");
        Place bank = new Place("Банк");
        Place rzdStation = new Place("Вокзал");
        Place shop = new Place("Универмаг");
        Place cinema = new Place("Кино");
        Place outside = new Place("Улица");
        Place hotel = new Place("Отель");

        //Persons pull

        Person krabs = new Person("Крабс", office);
        Person grizzle = new Person("Гризл", grizzleOffice);
        Person miga = new Person("Мига", office);
        Person julio = new Person("Жулио", office);
        Person debil = new Person("Незнайка", office);
        Person kozel = new Person("Козлик", office);
        Person bankWorker = new Person("Worker", bank);
        bankWorker.setMoney(100000000);
        Person shopWorker = new Person("Worker", shop);
        Person rzdWorker = new Person("Worker", rzdStation);
        Person cinemaWorker = new Person("Worker", cinema);
        Person visitor = new Person("Посетители", office);
        Person secretary = new Person("Секретарша", grizzleOffice);
        Person skuperfield = new Person("Скуперфильд", outside);
        Person god = new Person("");
        Person spectator = new Person("Наблюдатель со стороны");

        //Item pull

        TrainTicket tt1 = new TrainTicket(rzdWorker, 500, 11092001, "San-Komarik");
        TrainTicket tt2 = new TrainTicket(rzdWorker, 500, 11092001, "San-Komarik");
        BoxItem bag = new BoxItem("Чемодан", shopWorker, Material.FIBROLIT, shop);
        String film = "Таинственный незнакомец, или Рассказ о семи задушенных и одном утонувшем в мазуте";
        CinemaTicket ct1 = new CinemaTicket(cinemaWorker, 400, 10092001, film);
        CinemaTicket ct2 = new CinemaTicket(cinemaWorker, 400, 10092001, film);
        Item sales = new Item("Акции", miga, Material.PAPER, office);
        BoxItem wardrobe = new BoxItem("Шкаф", god, Material.IRON, office);
        wardrobe.setMoney(9999999);
        RecordItem list = new RecordItem("Листок бумаги", julio);
        BoxItem book = new BoxItem("Записная книжка", julio, Material.PAPER, julio.getWhereIsIt());
        var bookCont = book.getContain();
        bookCont.add(list);
        book.setContain(bookCont);
        Door door = new Door("Дверь", god, Material.WOOD, grizzleOffice, true);
        SpeakableItem button = new SpeakableItem("Кнопка звонка", god, Material.IRON, grizzleOffice, "Дин-дон");
        Item grizzlePen = new Item("Авторучка", grizzle, Material.DONTUNDERSTANDABLE, grizzleOffice);
        RecordItem grizzleList = new RecordItem("Лист бумаги", grizzle);
        BoxItem krabsBag = new BoxItem("Чемодан Крабса", krabs, Material.DONTUNDERSTANDABLE, krabs.getWhereIsIt());
        SpeakableItem trees = new SpeakableItem("Деревья", god, Material.WOOD, outside, "Шшепшешепепшпепш (перевод с деревьего: закройте лабу :) пожалуйста)");
        SpeakableItem birds = new SpeakableItem("Птички", god, Material.DONTUNDERSTANDABLE, outside, "Чырык-Чырык");
        Item flowers = new Item("Цветы", god, Material.DONTUNDERSTANDABLE, outside);

        //Actions pull

        Say say = new Say(krabs);
        Move move = new Move(krabs);
        Give give = new Give(krabs);
        Take take = new Take(krabs);
        Write write = new Write(krabs);
        Buy buy = new Buy(krabs);
        See see = new See(krabs);
        Has has = new Has(krabs);
        ItemSay itemSay = new ItemSay(button);
        var initiate = new Action(krabs) {
            public void initiate(ItemAction action, String method, Actionable thatDoIt, Object[] parameters) {
                InvokeMethod.invoke(action, method, thatDoIt, parameters);
            }
            @Override
            public String describe() {
                return getWhoDoIt().getName() + " initiate ";
            }
        };
        var unmove = new Action(krabs) {
            public void unmove(Person.Body.Piece pieceOfBody) {
                pieceOfBody.setCanMove(false);
            }
            @Override
            public String describe() {
                return getWhoDoIt().getName() + " cвязал ";
            }
        };
        var check = new Action() {
            public boolean check(Door door) {
                boolean bool = door.isClosed();
                System.out.println(describe() + door.getName() + " is closed - " + bool);
                return bool;
            }
            public boolean check(int was, int now, int need) {
                boolean bool = (now - was == need);
                System.out.println(describe() + "money is " + need + " fertings - " + bool);
                return bool;
            }
            @Override
            public String describe() {
                return getWhoDoIt().getName() + " check ";
            }
        };

        //code
        move.setWhoDoIt(krabs);
        move.move(grizzleOffice, TypeOfTravel.GO);
        see.setWhoDoIt(krabs);
        see.see(grizzle);
        see.takeAlias(new Person("Толстая крыса"));
        see.setWhoDoIt(grizzle);
        see.see(krabs);
        has.setWhoDoIt(grizzle);
        has.has(Has.Condition.SMILE);
        see.setWhoDoIt(krabs);
        see.see(door);
        check.setWhoDoIt(krabs);
        if (!check.check(door)) {
            System.out.println("А дверца-то открыта");
            door.setClosed(true);
            check.check(door);
        }
        say.setWhoDoIt(krabs);
        say.say("Я шепну тебе на ушко.. АННИГИЛЯТОРНАЯ ПУШКА", grizzle);
        move.setWhoDoIt(krabs);
        move.move(outside, TypeOfTravel.GO);
        take.setWhoDoIt(grizzle);
        take.take(grizzlePen, grizzleOffice);
        Item mouses = new Item("Крысы", grizzle, Material.DONTUNDERSTANDABLE, grizzleOffice);
        BoxItem polka = new BoxItem("Полка", grizzle, Material.WOOD, grizzleOffice);
        see.setWhoDoIt(spectator);
        see.see(write, "write", grizzle, new Object[]{"Мне было лень придумывать сюда какой-то текст", grizzleList});
        see.takeAlias(give, "give", grizzle, new Object[]{mouses, polka});
        initiate.setWhoDoIt(grizzle);
        initiate.initiate(itemSay, "say", button, null);
        give.setWhoDoIt(grizzle);
        give.give(grizzleList, secretary);

        //////////////////////////////////

        move.setWhoDoIt(krabs);
        move.move(bank, TypeOfTravel.RIDE);
        say.setWhoDoIt(krabs);
        say.say("Хочу деняк", bankWorker);
        give.setWhoDoIt(bankWorker);
        give.give(2000000, krabs);
        give.setWhoDoIt(krabs);
        give.give(2000000, krabsBag);
        move.setWhoDoIt(miga);
        move.move(rzdStation, TypeOfTravel.RIDE);
        move.setWhoDoIt(julio);
        move.move(rzdStation, TypeOfTravel.RIDE);
        buy.setWhoDoIt(miga);
        buy.buy(tt1.getCost(), tt1);
        buy.setWhoDoIt(julio);
        buy.buy(tt2.getCost(), tt2);
        give.setWhoDoIt(miga);
        give.give(tt1, julio);

        move.setWhoDoIt(miga);
        move.move(shop, TypeOfTravel.RIDE);
        move.setWhoDoIt(julio);
        move.move(shop, TypeOfTravel.RIDE);
        buy.setWhoDoIt(julio);
        buy.buy(1500, bag);

        move.setWhoDoIt(miga);
        move.move(cinema, TypeOfTravel.RIDE);
        move.setWhoDoIt(julio);
        move.move(cinema, TypeOfTravel.RIDE);
        buy.setWhoDoIt(miga);
        buy.buy(ct1.getCost(), ct1);
        buy.setWhoDoIt(julio);
        buy.buy(ct2.getCost(), ct2);

        move.setWhoDoIt(miga);
        move.move(office, TypeOfTravel.RIDE);
        move.setWhoDoIt(julio);
        move.move(office, TypeOfTravel.RIDE);

        say.setWhoDoIt(julio);
        say.say("Кароч фильм имба советую посмотреть", debil);
        say.say("Кароч фильм имба советую посмотреть", kozel);

        give.setWhoDoIt(miga);
        give.give(ct1, debil);
        give.give(600, debil);
        give.setWhoDoIt(julio);
        give.give(ct2, kozel);
        move.setWhoDoIt(debil);
        move.move(cinema, TypeOfTravel.RUN);
        move.setWhoDoIt(kozel);
        move.move(cinema, TypeOfTravel.RUN);

        buy.setWhoDoIt(visitor);
        buy.buy(2000, sales);

        take.setWhoDoIt(julio);
        take.take(999999, wardrobe);
        give.setWhoDoIt(julio);
        give.give(999999, bag);
        take.take(list, book);
        write.setWhoDoIt(julio);
        write.write("Текст записки", list);
        give.give(list, wardrobe);
        give.give(tt1, wardrobe);
        give.give(tt2, wardrobe);

        //////////////////////////////////

        say.setWhoDoIt(miga);
        say.say("Контора закрывается, приходите завтра", visitor);
        move.setWhoDoIt(visitor);
        move.move(outside, TypeOfTravel.GO);
        take.setWhoDoIt(julio);
        take.take(bag, office);
        move.setWhoDoIt(julio);
        move.move(hotel, TypeOfTravel.RIDE);
        move.setWhoDoIt(miga);
        move.move(hotel, TypeOfTravel.RIDE);
        move.setWhoDoIt(krabs);
        move.move(hotel, TypeOfTravel.RIDE);

        give.setWhoDoIt(krabs);
        give.give(krabsBag, julio);
        var was = julio.getMoney();
        take.setWhoDoIt(julio);
        take.take(krabsBag.getMoney(), krabsBag);
        check.setWhoDoIt(julio);
        if(!check.check(was, julio.getMoney(), 2000000)) {
            System.out.println("Крабс не принёс 2000000.. Жулио расстроился");
            return;
        }
        give.setWhoDoIt(julio);
        give.give(100000, krabs);
        say.setWhoDoIt(julio);
        say.say("Хаха у меня больше", krabs);

        has.setWhoDoIt(skuperfield);
        has.has(Has.Condition.SAD);
        unmove.setWhoDoIt(krabs);
        unmove.unmove(skuperfield.getBody().getLegs());
        unmove.unmove(skuperfield.getBody().getHands());
        unmove.unmove(skuperfield.getBody().getMouth());
        move.setWhoDoIt(skuperfield);
        for (int i = 0; i < 4; i++) {
            move.move(new Place("куда-нибудь"), TypeOfTravel.GO);
            has.has(Has.Condition.PAIN);
        }
        has.has(Has.Condition.HUMILITY);
        has.has(Has.Condition.DEFAULT);
        see.setWhoDoIt(skuperfield);
        see.see(trees);
        see.takeAlias(itemSay, "say", trees, null);
        see.see(flowers);
        has.has(Has.Condition.HAPPY);
        see.see(itemSay, "say", birds, null);
        see.see(birds);
        has.has(Has.Condition.HAPPY);
    }
}
