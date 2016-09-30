package com.example.han.seatpickingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.han.seatpickingdemo.widget.SeatTable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeatTable seatTableView = (SeatTable) findViewById(R.id.seatView);

        seatTableView.setScreenName("6号厅大荧幕");
        seatTableView.setMaxSelected(3);//设置最多选中数

        seatTableView.setSeatChecker(new SeatTable.SeatChecker() {

            @Override
            public boolean isValidSeat(int row, int column) {
                if (column == 2) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean isSold(int row, int column) {
                if (row == 6 && column == 6) {
                    return true;
                }
                return false;
            }

            @Override
            public void checked(int row, int column) {

            }

            @Override
            public void unCheck(int row, int column) {

            }

        });

        seatTableView.getSelectedSeats();

        seatTableView.setData(10, 15);
    }
}
