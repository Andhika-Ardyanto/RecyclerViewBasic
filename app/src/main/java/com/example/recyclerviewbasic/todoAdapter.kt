package com.example.recyclerviewbasic

import android.app.AlertDialog
import android.content.DialogInterface
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewbasic.databinding.ListItemBinding
import org.w3c.dom.Text

class todoAdapter(private val myDataset: MutableList<String>) :
    RecyclerView.Adapter<todoAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.todoText.text = myDataset[position]


        //menghapus
        holder.delBtn.setOnClickListener {
            myDataset.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, myDataset.size)
        }

        //mengedit
        holder.edtBtn.setOnClickListener {
            val context = holder.itemView.context

            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.edit_item, null)

            //mengambil data sebelumnya
            val priviewtext = myDataset[position]
            val editText = view.findViewById<TextView>(R.id.editTextt)
            editText.text = priviewtext

            //dialog
            var alertDialog = AlertDialog.Builder(context)
            alertDialog.setTitle("Edit Item")
                .setView(view)
                .setPositiveButton("Update", DialogInterface.OnClickListener { dialog, id ->

                    //edit
                    myDataset[position] = editText.text.toString()
                    notifyDataSetChanged()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                })

            alertDialog.create().show()
        }
    }

    override fun getItemCount() = myDataset.size

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val todoText = binding.todoItem
        val delBtn = binding.btndelete
        val edtBtn = binding.btnEdit
    }

}