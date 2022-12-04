package com.example.moviechest

import androidx.recyclerview.widget.DiffUtil

  class MovieDiffUtilCallBack(
    private val oldList: List<MovieItem>,
    private val newList: List<MovieItem>)
    : DiffUtil.Callback() {

      override fun getOldListSize(): Int {
          return oldList.size
      }

      override fun getNewListSize(): Int {
         return newList.size
      }

      override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
          return oldList[oldItemPosition].id == newList[newItemPosition].id
      }

      override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
          val oldItem = oldList[oldItemPosition]
          val newItem = newList[newItemPosition]
          return oldItem == newItem
      }
  }
