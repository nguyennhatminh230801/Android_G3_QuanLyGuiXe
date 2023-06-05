package sloveUser;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter {

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgAvt;
        private TextView tvName, tvInfor;

        public UserViewHolder(@NonNull View itemView) {

            super(itemView);

            //imgAvt =  itemView.findViewById(R.id.img_avt);
            
        }
    }
}
