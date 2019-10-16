package id.kampuskoding.tugaslistview3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    //constructor
    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }


    public class ViewHolder {
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());
        //set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                if (modellist.get(postition).getTitle().equals("ichidaime")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "ichidaime");
                    intent.putExtra("contentTv", "Inilah presiden Pertama kita");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("nidaime")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "nidaime");
                    intent.putExtra("contentTv", "Inilah presiden kedua kita");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("sandaime")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "sandaime");
                    intent.putExtra("contentTv", "Inilah presiden ketiga kita");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("yondaime")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "yondaime");
                    intent.putExtra("contentTv", "Inilah presiden keempat kita");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("godaime")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "godaime");
                    intent.putExtra("contentTv", "Inilah presiden kelima kita");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("rokudaime")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "rokudaime");
                    intent.putExtra("contentTv", "Inilah presiden keenam kita");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("nanadaime")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "nanadaime");
                    intent.putExtra("contentTv", "Inilah presiden ketujuh kita");
                    mContext.startActivity(intent);
                }
            }
        });



        return view;
                                }
                //filter
        public void filter(String charText){
            charText = charText.toLowerCase(Locale.getDefault());
            modellist.clear();
            if (charText.length()==0){
                modellist.addAll(arrayList);
            }
            else {
                for (Model model : arrayList){
                    if (model.getTitle().toLowerCase(Locale.getDefault())
                            .contains(charText)){
                        modellist.add(model);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }