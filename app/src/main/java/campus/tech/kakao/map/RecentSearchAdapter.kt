package campus.tech.kakao.map

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class RecentSearchAdapter(private val recentDataList: List<String>) : BaseAdapter() {
    override fun getCount(): Int = recentDataList.size

    override fun getItem(position: Int): Any = recentDataList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(parent?.context)
            .inflate(R.layout.recent_search_item, parent, false)
        val recentDataViewHolder =
            view.tag as? RecentViewHolder ?: RecentViewHolder(view).also { view.tag = it }
        recentDataViewHolder.name.text = getItem(position) as String
        return view
    }

    class RecentViewHolder(view:View){
        val name : TextView = view.findViewById(R.id.recent_search)
    }
}