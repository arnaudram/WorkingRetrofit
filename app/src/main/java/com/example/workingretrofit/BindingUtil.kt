package com.example.workingretrofit

import android.content.res.Resources
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Transformations
import com.example.workingretrofit.imagelist.LoadStatus
import com.example.workingretrofit.model.EntityNetwork
import com.squareup.picasso.Picasso

@BindingAdapter("bind_imageNetWork")
fun ImageView.imageItem(entityNetwork: EntityNetwork){
    val uri= Uri.parse(entityNetwork.imgSrc).buildUpon().scheme("https").build()
    uri?.let {
        Picasso.get().load(it)
            .placeholder(R.drawable.ic_launcher_background).fit()
            .into(this)
    }


}
@BindingAdapter("bind_typeNetWork")
fun TextView.typeItem(entityNetwork: EntityNetwork){
    this.text=entityNetwork.type

}
@BindingAdapter("bind_idNetWork")
fun TextView.idItem(entityNetwork: EntityNetwork){
    this.text=entityNetwork.id

}
@BindingAdapter("bind_priceNetWork")
fun TextView.priceItem(entityNetwork: EntityNetwork){
    val price=entityNetwork.price.toString()
    this.text=price


}
@BindingAdapter("bind_statusNetWork")
fun ProgressBar.statusNetWork(status: LoadStatus?){

status?.let{
    when(it){
        LoadStatus.LOADING->{this.visibility=View.VISIBLE}
        LoadStatus.DONE->{this.visibility=View.GONE}
        LoadStatus.ERROR->{

            this.progressDrawable=resources.getDrawable(R.drawable.ic_error_outline_black_24dp)
            this.visibility=View.VISIBLE
        }
    }
}
}