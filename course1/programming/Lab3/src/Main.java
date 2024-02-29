import actions.*;
import enums.Material;
import enums.TypeOfTravel;
import real.objects.*;
import real.objects.items.*;

public class Main {
    public static void main(String[] args) {
        //Places
        Place office = new Place("Контора");
        Place bank = new Place("Банк");
        Place rzdStation = new Place("Вокзал");
        Place shop = new Place("Универмаг");
        Place cinema = new Place("Кино");
        Place outside = new Place("Улица");

        //Persons
        Person krabs = new Person("Крабс", office);
        Person grizzle = new Person("Гризл", office);
        Person miga = new Person("Мига", office);
        Person julio = new Person("Жулио", office);
        Person debil = new Person("Незнайка", office);
        Person kozel = new Person("Козлик", office);
        Person bankWorker = new Person("Worker", shop);
        bankWorker.getMoney().setNominal(100000);
        Person shopWorker = new Person("Worker", shop);
        Person rzdWorker = new Person("Worker", rzdStation);
        Person cinemaWorker = new Person("Worker", cinema);
        Person visitor = new Person("Посетители", office);
        Person officeOwner = new Person("OO", office);

        //Items
        TrainTicket tt1 = new TrainTicket("Билет", rzdWorker, 500, 11092001, "San-Komarik");
        TrainTicket tt2 = new TrainTicket("Билет", rzdWorker, 500, 11092001, "San-Komarik");
        BoxItem bag = new BoxItem("Чемодан", shopWorker, Material.FIBROLIT);
        String film = "Таинственный незнакомец, или Рассказ о семи задушенных и одном утонувшем в мазуте";
        CinemaTicket ct1 = new CinemaTicket("Билет", cinemaWorker, 400, 10092001, film);
        CinemaTicket ct2 = new CinemaTicket("Билет", cinemaWorker, 400, 10092001, film);
        Item sales = new Item("Акции", miga, Material.PAPER);
        Money moneys = new Money("Деньги", officeOwner, 9999999);
        BoxItem wardrobe = new BoxItem("Шкаф", officeOwner, Material.IRON);
        wardrobe.getContain().add(moneys);
        RecordItem list = new RecordItem("Листок бумаги", julio);
        BoxItem book = new BoxItem("Записная книжка", julio, Material.PAPER);
        book.getContain().add(list);


        //Actions
        Say say = new Say(krabs);
        MoveTo move = new MoveTo(krabs);
        Give give = new Give(krabs);
        Take take = new Take(krabs);
        Write write = new Write(krabs);
        Buy buy = new Buy(krabs);

        move.setWhoDoIt(krabs);
        move.setPlace(bank, TypeOfTravel.RIDE);

        //
        say.setWhoDoIt(krabs);
        say.sayPhrase("Хочу деняк", bankWorker);
        give.setWhoDoIt(bankWorker);
        give.giveMoney(10000, krabs);

        move.setWhoDoIt(miga);
        move.setPlace(rzdStation, TypeOfTravel.RIDE);
        move.setWhoDoIt(julio);
        move.setPlace(rzdStation, TypeOfTravel.RIDE);
        buy.setWhoDoIt(miga);
        buy.buy(tt1.getCost(), tt1);
        buy.setWhoDoIt(julio);
        buy.buy(tt2.getCost(), tt2);
        give.setWhoDoIt(miga);
        give.changeOwner(tt1, julio);

        move.setWhoDoIt(miga);
        move.setPlace(shop, TypeOfTravel.RIDE);
        move.setWhoDoIt(julio);
        move.setPlace(shop, TypeOfTravel.RIDE);
        buy.setWhoDoIt(julio);
        buy.buy(1500, bag);

        move.setWhoDoIt(miga);
        move.setPlace(cinema, TypeOfTravel.RIDE);
        move.setWhoDoIt(julio);
        move.setPlace(cinema, TypeOfTravel.RIDE);
        buy.setWhoDoIt(miga);
        buy.buy(ct1.getCost(), ct1);
        buy.setWhoDoIt(julio);
        buy.buy(ct2.getCost(), ct2);

        move.setWhoDoIt(miga);
        move.setPlace(office, TypeOfTravel.RIDE);
        move.setWhoDoIt(julio);
        move.setPlace(office, TypeOfTravel.RIDE);

        say.setWhoDoIt(julio);
        say.sayPhrase("Кароч фильм имба советую посмотреть", debil);
        say.sayPhrase("Кароч фильм имба советую посмотреть", kozel);

        give.setWhoDoIt(miga);
        give.changeOwner(ct1, debil);
        give.giveMoney(600, debil);
        give.setWhoDoIt(julio);
        give.changeOwner(ct2, kozel);

        move.setWhoDoIt(debil);
        move.setPlace(cinema, TypeOfTravel.RUN);
        move.setWhoDoIt(kozel);
        move.setPlace(cinema, TypeOfTravel.RUN);

        buy.setWhoDoIt(visitor);
        buy.buy(2000, sales);

        take.setWhoDoIt(julio);
        take.takeFromBox(moneys, wardrobe);
        give.setWhoDoIt(julio);
        give.giveInBox(moneys, bag);

        take.takeFromBox(list, book);
        write.setWhoDoIt(julio);
        write.addText("Текст записки", list);
        give.giveInBox(list, wardrobe);
        give.giveInBox(tt1, wardrobe);
        give.giveInBox(tt2, wardrobe);
        //

    }

}
