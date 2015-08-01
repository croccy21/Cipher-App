package com.joelgoddard.cipherapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.joelgoddard.cipherapp.cipher.Cipher;

import java.util.List;

/**
 * Created by Joel Goddard on 01/08/2015.
 */
public class CipherAdapter extends ArrayAdapter{

    private Context context;
    private boolean useList = true;

    public CipherAdapter(Context context, List items) {
        super(context, R.layout.cipher_item, items);
        this.context = context;
    }

    /**
     * Holder for the list items.
     */
    private class ViewHolder{
        TextView name;
        TextView description;
        TextView type;
        TextView[] modes = new TextView[3];
        TextView warning;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Cipher item = (Cipher)getItem(position);
        View viewToUse = null;

        // This block exists to inflate the settings list item conditionally based on whether
        // we want to support a grid or list view.
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            if(useList){
                viewToUse = mInflater.inflate(R.layout.cipher_item, null);
            } else {
                viewToUse = mInflater.inflate(R.layout.cipher_item, null);
            }

            holder = new ViewHolder();
            holder.name = (TextView)viewToUse.findViewById(R.id.cipher_name);
            holder.description = (TextView)viewToUse.findViewById(R.id.cipher_description);
            holder.modes[Cipher.CIPHER_ENCODE] = (TextView)viewToUse.findViewById(R.id.display_encryption);
            holder.modes[Cipher.CIPHER_DECODE] = (TextView)viewToUse.findViewById(R.id.display_decryption);
            holder.modes[Cipher.CIPHER_AUTO_SOLVE] = (TextView)viewToUse.findViewById(R.id.display_auto_solve);
            viewToUse.setTag(holder);
        } else {
            viewToUse = convertView;
            holder = (ViewHolder) viewToUse.getTag();
        }

        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());

        for(int i=0;i<3;i++){
            if (item.getAvailableMode(i)){
                holder.modes[i].setVisibility(View.VISIBLE);
            }
            else{
                holder.modes[i].setVisibility(View.INVISIBLE);
            }
        }
        return viewToUse;
    }
}
