package com.android.hl.explain;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.hl.base.BaseFragment;


public abstract class SimpleFragment extends BaseFragment {
	@android.support.annotation.IdRes
	private int id_test=101;
	private View layout;
	private EditText numberET, labelET;
	private Button insertBT;
	int signWidth = 180, signHeight = 60, MATCH = LayoutParams.MATCH_PARENT,
			WRAP = LayoutParams.WRAP_CONTENT;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// layout = inflater.inflate(R.layout.fragment_insert_content_hl,
		// container, false);
		// init();
		layout = initLayout(activity);
		return layout;
	}

	private void init() {
//		numberET = (EditText) layout.findViewById(R.id.insert_number_signet_hl);
//		labelET = (EditText) layout.findViewById(R.id.insert_label_signet_hl);
//		insertBT = (Button) layout.findViewById(R.id.insert_button_hl);
		insertBT.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				insertAccount();
			}
		});
	}

	private View initLayout(Context context) {
		RelativeLayout layout = new RelativeLayout(context);
		RelativeLayout.LayoutParams layoutParams = getRelativeParams(
				MATCH, MATCH);
		layout.setLayoutParams(layoutParams);
		TextView signTV = new TextView(context);
		RelativeLayout.LayoutParams signParams = getRelativeParams(
				signWidth, signHeight);

		signTV.setLayoutParams(getRelativeParams(signWidth, signHeight));

		signTV.setId(id_test);

		signTV.setText("起步了");
		TextView rightTV = new TextView(context);
		RelativeLayout.LayoutParams rightParams = getRelativeParams(
				MATCH,MATCH);
		viewVertical(rightParams, true, id_test);
		rightTV.setLayoutParams(rightParams);
		rightTV.setText("右边");

		TextView belowTV = new TextView(context);
		RelativeLayout.LayoutParams belowParams = getRelativeParams(
				MATCH, signHeight);
		viewHorizontal(belowParams, true, id_test);
		belowTV.setLayoutParams(belowParams);
		belowTV.setText("下边边");
		signTV.setBackgroundColor(Color.RED);
		rightTV.setBackgroundColor(Color.YELLOW);
		belowTV.setBackgroundColor(Color.GREEN);

		layout.addView(signTV);
		layout.addView(rightTV);
		layout.addView(belowTV);
		return layout;
	}

	private void viewVertical(RelativeLayout.LayoutParams params,
			boolean isRight, int anchor) {
		params.addRule(RelativeLayout.ALIGN_BOTTOM, anchor);
		params.addRule(RelativeLayout.ALIGN_TOP, anchor);
		params.addRule(isRight ? RelativeLayout.RIGHT_OF
				: RelativeLayout.LEFT_OF, anchor);
	}

	private void viewHorizontal(RelativeLayout.LayoutParams params,
			boolean isBelow, int anchor) {
		params.addRule(RelativeLayout.ALIGN_LEFT, anchor);
		params.addRule(RelativeLayout.ALIGN_RIGHT, anchor);
		params.addRule(isBelow ? RelativeLayout.BELOW : RelativeLayout.ABOVE,
				anchor);
	}


	private LinearLayout.LayoutParams getLinearParams(int width,
			int height) {
		return new LinearLayout.LayoutParams(width, height);
	}

	private LinearLayout.LayoutParams getLinearParams(int width,
			int height, float weight) {
		return new LinearLayout.LayoutParams(width, height, weight);
	}

	private void insertAccount() {
//		String numberStr = numberET.getText().toString();
//		if (TextUtils.isEmpty(numberStr)) {
//			activity.showToast(activity.getResources().getString(
//					R.string.insert_error_number_hl));
//			return;
//		}
//		String labelStr = labelET.getText().toString();
//		Account account = new Account();
//		int number = Integer.parseInt(numberStr);
//		account.setNumber(number);
//		account.setLabel(labelStr);
//		SQLiteUtils.addAccount(account, activity);
//		emptyEditText(numberET);
//		emptyEditText(labelET);
	}

	private void emptyEditText(EditText editText) {
		editText.setText("");
		editText.clearComposingText();
	}

	@Override
	protected void initTitle() {
		titleStr = "simple";
	}
}
