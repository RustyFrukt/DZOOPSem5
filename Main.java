import models.TableModel;
import presenters.BookingPresenter;
import presenters.Model;
import views.BookingView;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Model tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.showTables();

        bookingView.reservationTable(new Date(), 111, "Vadim");

        bookingView.reservationTable(new Date(), 102, "Vadim");

        bookingView.changeReservationTable(1001, new Date(), 102, "Vadim");
    }
}