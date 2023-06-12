package models;

import presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {
    private Collection<Table> tables;

    /**
     * Получить все столики
     *
     * @return
     */
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());

        }

        return tables;
    }

    /**
     * Бронирование столика
     *
     * @param reservationDate Дата бронирования
     * @param tableNo         Номер столика
     * @param name            Имя клиента
     */
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        Table table = getTable(tableNo);
        return createNewReservation(reservationDate, name, table).getId();
    }

    private Reservation createNewReservation(Date reservationDate, String name, Table table){
        Reservation reservation = new Reservation(reservationDate, name);
        table.getReservations().add(reservation);
        return reservation;
    }

    private Table getTable(int tableNo) {
        for (Table table : tables) {
            if (table.getNo() == tableNo)
                return table;
        }
        throw new RuntimeException("Некорректный номер столика.");
    }


    /**
     * TODO: Разработать самостоятельно в рамках домашней работы
     * Поменять бронь столика
     */
    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        Table table = getTable(tableNo);
        table.deleteReservation(oldReservation);
        return createNewReservation(reservationDate, name, table).getId();
    }
}
