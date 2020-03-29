package com.example.homework2.Exercise3;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework2.R;
import com.example.homework2.Exercise3.model.Message;
import com.example.homework2.Exercise3.widget.CircleImageView;

import java.util.List;


// 适配器
public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder> {

    private static final String TAG = "GreenAdapter";

    private int mNumberItems;

    private final ListItemClickListener mOnClickListener;

    private static int viewHolderCount;

    private List<Message> messageList;

    public GreenAdapter(int numListItems, ListItemClickListener listener, List<Message> messages) {
        mNumberItems = numListItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
        messageList = messages;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        viewHolder.description.setText("ViewHolder index: " + viewHolderCount);

        viewHolder.itemView.setBackgroundColor(Color.rgb(0, 125, 125));
        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: " + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: #" + position);
        numberViewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView official;
        private CircleImageView  icon;
        private TextView description;
        private TextView title;
        private TextView time;
        private int position;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.iv_avatar);
            official = itemView.findViewById(R.id.robot_notice);
            title = itemView.findViewById(R.id.tv_title);
            description = itemView.findViewById(R.id.tv_description);
            time = itemView.findViewById(R.id.tv_time);
            itemView.setOnClickListener(this);
        }

        public void bind(int bindPosition) {
            position = bindPosition;
            title.setText(messageList.get(bindPosition).getDescription());
            description.setText(messageList.get(bindPosition).getDescription());
            time.setText(messageList.get(bindPosition).getTime());
            switch (messageList.get(position).getIcon()) {
                case "TYPE_USER":
                    icon.setImageResource(R.drawable.icon_girl);
                    break;
                case "TYPE_STRANGER":
                    icon.setImageResource(R.drawable.session_stranger);
                    break;
                case "TYPE_ROBOT":
                    icon.setImageResource(R.drawable.session_robot);
                    break;
                case "TYPE_SYSTEM":
                    icon.setImageResource(R.drawable.session_system_notice);
                    break;
                case "TYPE_GAME":
                    icon.setImageResource(R.drawable.icon_micro_game_comment);
                    break;
            }
            if (messageList.get(bindPosition).isOfficial())
                official.setVisibility(View.VISIBLE);
            else
                official.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            if (mOnClickListener != null) {
                mOnClickListener.onListItemClick(clickedPosition);
            }
        }
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
