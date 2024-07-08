package campus.tech.kakao.map

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecentSearchAdapter(
    private val recentDataList: List<String>,
    private val viewModel: RecentViewModel
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class RecentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.recent_search)
        val deleteBtn: ImageButton = view.findViewById(R.id.delete_recent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recent_search_item, parent, false)
        return RecentViewHolder(view)
    }

    override fun getItemCount(): Int = recentDataList.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = recentDataList[position]
        val viewHolder = holder as RecentViewHolder
        viewHolder.name.text = item
        viewHolder.deleteBtn.setOnClickListener {
            viewModel.deleteRecentData(item)
        }
    }
}