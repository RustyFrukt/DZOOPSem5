package presenters;

import models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {
    /**
     * Отображение списка столиков в приложении
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Установить наблюдателя, отслеживающего действия пользователя
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    void printReservationTableResult(int reservationNo);

    void printReservationTableError(String errorMessage);

}
