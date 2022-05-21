package com.nknd.shoppi_android

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shoppi.app.model.Banner
import org.w3c.dom.Text
import java.text.DecimalFormat
import kotlin.math.roundToInt


class HomeBannerAdapter: ListAdapter<Banner,HomeBannerAdapter.HomeBannerViewHolder>(BannerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_banner, parent, false)
        return HomeBannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HomeBannerViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val bannerImageView = view.findViewById<ImageView>(R.id.iv_banner_image)
        private val bannerBadgeTextView = view.findViewById<TextView>(R.id.tv_banner_badge)
        private val bannerTitleTextView = view.findViewById<TextView>(R.id.tv_banner_title)
        private val bannerDetailThumbnailView = view.findViewById<ImageView>(R.id.iv_banner_detail_thumbnail)
        private val bannerDetailBrandLabelTextView = view.findViewById<TextView>(R.id.tv_banner_detail_brand_label)
        private val bannerDetailProductLabelTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_label)
        private val bannerDetailDiscountRateTextView = view.findViewById<TextView>(R.id.tv_banner_product_detail_discount_rate)
        private val bannerDetailDiscountPriceTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_discount_price)
        private val bannerDetailPriceTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_price)

        fun bind(banner: Banner){
            loadImage(banner.backgroundImageUrl, bannerImageView)
            bannerBadgeTextView.text = banner.badge.label
            bannerBadgeTextView.background = ColorDrawable(Color.parseColor(banner.badge.backgroundColor))
            bannerTitleTextView.text = banner.label
            loadImage(banner.productDetail.thumbnailImageUrl, bannerDetailThumbnailView)
            bannerDetailBrandLabelTextView.text = banner.productDetail.brandName
            bannerDetailProductLabelTextView.text = banner.productDetail.label
            bannerDetailDiscountRateTextView.text = "${banner.productDetail.discountRate}%"
            calculateDiscountAmount(bannerDetailDiscountPriceTextView, banner.productDetail.discountRate, banner.productDetail.price)
            applyPriceFormat(bannerDetailPriceTextView, banner.productDetail.price)
        }

        private fun calculateDiscountAmount(view: TextView, discountRate: Int, price: Int){
            val discountPrice = (((100 - discountRate) / 100.0) * price).roundToInt()
            applyPriceFormat(view, discountPrice)
        }

        private fun applyPriceFormat(view: TextView, price: Int) {
            val decimalFormat = DecimalFormat("#,###")
            view.text = decimalFormat.format(price) + "원"
        }

        private fun loadImage(urlString: String, imageView: ImageView) {
            GlideApp.with(itemView)
                .load(urlString)
                .into(imageView)
        }
    }
}

class BannerDiffCallback: DiffUtil.ItemCallback<Banner>() {
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }
}