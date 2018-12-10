package com.example.jingzehuang.propellerhealth.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import com.example.jingzehuang.propellerhealth.R;
import com.example.jingzehuang.propellerhealth.utils.DateUtils;
import java.util.Calendar;
import java.util.Date;

public class NewEventDialog extends DialogFragment implements
    DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

  public static final String TAG = "NewEventDialog";

  private Date timestamp;
  private OnDataUpdate onDataUpdate;

  @BindView(R.id.new_event_name)Spinner nameSp;
  @BindView(R.id.new_event_type)TextView typeTv;
  @BindView(R.id.new_event_timestamp_date)TextView dateTv;
  @BindView(R.id.new_event_timestamp_time)TextView timeTv;

  interface OnDataUpdate {
    void update(String name, String type, Date date);
  }

  public static NewEventDialog newInstance(OnDataUpdate onDataUpdate) {
    NewEventDialog dialog = new NewEventDialog();
    dialog.setOnDataUpdate(onDataUpdate);
    return dialog;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.dialog_new_event, container, false);
    setCancelable(false);
    ButterKnife.bind(this, view);

    return view;
  }

  public void setOnDataUpdate(OnDataUpdate onDataUpdate) {
    this.onDataUpdate = onDataUpdate;
  }

  @OnItemSelected(R.id.new_event_name)
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    String type = this.getResources().getStringArray(R.array.medication_types)[position];
    typeTv.setText(type);
  }

  @OnClick(R.id.new_event_timestamp_date)
  public void onPickDateClick(View v) {
    Calendar c = getCalendarFromTimestamp();
    Dialog dialog = new DatePickerDialog(
        getContext(),
        NewEventDialog.this,
        c.get(Calendar.YEAR),
        c.get(Calendar.MONTH),
        c.get(Calendar.DAY_OF_MONTH));
    dialog.show();
  }

  @OnClick(R.id.new_event_timestamp_time)
  public void onPickTimeClick(View v) {
    Calendar c = getCalendarFromTimestamp();
    Dialog dialog = new TimePickerDialog(
        getContext(),
        NewEventDialog.this,
        c.get(Calendar.HOUR_OF_DAY),
        c.get(Calendar.MINUTE),
        true);
    dialog.show();
  }


  @OnClick(R.id.new_event_cancel_btn)
  public void onCancelBtnClick(View v) {
    dismiss();
  }

  @OnClick(R.id.new_event_save_btn)
  public void onSaveBtnClick(View v) {
    onDataUpdate.update(nameSp.getSelectedItem().toString(), typeTv.getText().toString(), getTimestamp());
    dismiss();
  }

  @Override
  public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
    Calendar c = getCalendarFromTimestamp();
    c.set(year, monthOfYear, dayOfMonth);

    timestamp = c.getTime();
    dateTv.setText(DateUtils.dateToStringDate(timestamp));
  }

  @Override
  public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
    Calendar c = getCalendarFromTimestamp();
    c.set(Calendar.HOUR_OF_DAY, hourOfDay);
    c.set(Calendar.MINUTE, minute);

    timestamp = c.getTime();
    timeTv.setText(DateUtils.dateToStringTime(timestamp));
  }

  private Calendar getCalendarFromTimestamp() {
    Calendar c = Calendar.getInstance();
    if (timestamp != null) {
      c.setTime(timestamp);
    }
    return c;
  }

  private Date getTimestamp() {
    return timestamp != null ? timestamp : Calendar.getInstance().getTime();
  }

}
