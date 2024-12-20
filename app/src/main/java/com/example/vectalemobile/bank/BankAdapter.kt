package com.example.vectalemobile.bank

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.vectalemobile.R
import com.example.vectalemobile.RibActivity

class BankAdapter(
    private val context: Context,
    private val bankList: List<Bank>,
    private val onImageSelected: (Int, Uri) -> Unit
) : RecyclerView.Adapter<BankAdapter.BankViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_bank, parent, false)
        return BankViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        val bank = bankList[position]
        holder.bankName.text = bank.name
        holder.bankNumber.text = bank.rib


        holder.sendButton.visibility = View.GONE
        holder.imageUriTextView.visibility = View.GONE


        holder.uploadImageButton.setOnClickListener {
            onImageSelected(position, Uri.EMPTY)
        }


        holder.sendButton.setOnClickListener {
            holder.selectedImageUri?.let { uri ->
                ReceiptStorage().receiptList.add(uri) // Save URI to ReceiptStorage
                Toast.makeText(context, "Image sent: $uri", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int = bankList.size

    fun updateItemWithImage(position: Int, uri: Uri) {
        val holder = (context as RibActivity).recyclerView.findViewHolderForAdapterPosition(position) as? BankViewHolder
        holder?.let {
            it.selectedImageUri = uri
            it.imageUriTextView.text = uri.toString()
            it.imageUriTextView.visibility = View.VISIBLE
            it.sendButton.visibility = View.VISIBLE
        }
    }

    class BankViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bankName: TextView = itemView.findViewById(R.id.bankName)
        val bankNumber: TextView = itemView.findViewById(R.id.bankNumber)
        val uploadImageButton: Button = itemView.findViewById(R.id.uploadImageButton)
        val sendButton: Button = itemView.findViewById(R.id.sendButton)
        val imageUriTextView: TextView = itemView.findViewById(R.id.imageUriTextView)
        var selectedImageUri: Uri? = null
    }
}
