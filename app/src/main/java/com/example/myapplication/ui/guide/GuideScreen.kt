package com.example.myapplication.ui.guide

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.util.Calendar

data class CongestionInfo(
    val name: String,
    val levelText: String,
    val detail: String
)

data class Recommendation(
    val name: String,
    val summary: String,
    val detail: String
)

@Composable
fun GuideScreen() {
    val scrollState = rememberScrollState()
    val currentHour = currentHourOfDay()
    val congestionList = remember(currentHour) { calculateCongestion(currentHour) }
    var transportPref by rememberSaveable { mutableStateOf("MTR") }
    val recommendation = remember(currentHour, transportPref) {
        getRecommendation(currentHour, transportPref)
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            Text(
                text = "Cross-Border Guide",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Today’s Crowd Level",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            congestionList.forEach { info ->
                CongestionCard(info = info)
                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            ChecklistSection(
                title = "Pre-departure Checklist",
                items = listOf(
                    "Travel document (回乡证 / 护照 / 通行证)",
                    "Valid visa or entry permit (如需要)",
                    "Mainland ID / 香港身份证",
                    "Octopus / 支付宝香港 / 银行卡",
                    "手机电量充足",
                    "充电宝与数据线",
                    "少量现金 (HKD)",
                    "雨伞 / 外套视天气而定"
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Recommended Checkpoint For You",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                ElevatedButton(
                    onClick = { transportPref = "MTR" },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(if (transportPref == "MTR") "MTR (Selected)" else "MTR")
                }
                ElevatedButton(
                    onClick = { transportPref = "BUS" },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(if (transportPref == "BUS") "Bus / Car (Selected)" else "Bus / Car")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            RecommendationCard(recommendation = recommendation)

            Spacer(modifier = Modifier.height(16.dp))

            TipsSection()
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun CongestionCard(info: CongestionInfo) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = when {
                info.levelText.startsWith("🔴") -> MaterialTheme.colorScheme.errorContainer
                info.levelText.startsWith("🟠") -> MaterialTheme.colorScheme.secondaryContainer
                else -> MaterialTheme.colorScheme.primaryContainer
            }
        )
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = info.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = info.levelText,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = info.detail,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun ChecklistSection(title: String, items: List<String>) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(8.dp))

    var checkedStates by rememberSaveable {
        mutableStateOf(List(items.size) { false })
    }

    items.forEachIndexed { index, label ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                checked = checkedStates[index],
                onCheckedChange = {
                    val newList = checkedStates.toMutableList()
                    newList[index] = it
                    checkedStates = newList
                }
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun RecommendationCard(recommendation: Recommendation) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = recommendation.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = recommendation.summary,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = recommendation.detail,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun TipsSection() {
    Text(
        text = "Practical Tips",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(8.dp))
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text("• 工作日 7–10 AM、5–8 PM 为高峰时段，尽量错峰出行。")
            Spacer(modifier = Modifier.height(4.dp))
            Text("• 福田口岸：适合坐地铁，换乘方便，人流相对分散。")
            Spacer(modifier = Modifier.height(4.dp))
            Text("• 罗湖口岸：经典口岸，人多但列车班次密，适合熟悉路线的通勤者。")
            Spacer(modifier = Modifier.height(4.dp))
            Text("• 深圳湾口岸：适合巴士 / 打车，周末、节假日前后会非常拥挤。")
            Spacer(modifier = Modifier.height(4.dp))
            Text("• 如可使用 e-Channel，过关速度会明显提高。")
            Spacer(modifier = Modifier.height(4.dp))
            Text("• 提前截图或下载离线二维码，防止信号差无法出示页面。")
        }
    }
}

fun currentHourOfDay(): Int {
    val calendar = Calendar.getInstance()
    return calendar.get(Calendar.HOUR_OF_DAY)
}

fun calculateCongestion(hour: Int): List<CongestionInfo> {
    val futianLevel = when (hour) {
        in 7..9, in 17..19 -> "🔴 Busy"
        in 10..11, in 15..16 -> "🟠 Moderate"
        else -> "🟢 Smooth"
    }
    val futianDetail = "Peak for MTR commuters around work hours."

    val luohuLevel = when (hour) {
        in 7..10, in 17..20 -> "🔴 Busy"
        else -> "🟠 Moderate"
    }
    val luohuDetail = "Classic checkpoint, more tour groups and commuters."

    val szBayLevel = when (hour) {
        in 8..10, in 17..20 -> "🟠 Moderate"
        else -> "🟢 Smooth"
    }
    val szBayDetail = "Popular for buses and cars; avoid just before holidays."

    return listOf(
        CongestionInfo("Futian Port", futianLevel, futianDetail),
        CongestionInfo("Lo Wu", luohuLevel, luohuDetail),
        CongestionInfo("Shenzhen Bay", szBayLevel, szBayDetail)
    )
}

fun getRecommendation(hour: Int, transportPref: String): Recommendation {
    return if (transportPref == "BUS") {
        if (hour in 22..23 || hour in 0..6) {
            Recommendation(
                name = "Huanggang Port",
                summary = "24-hour bus crossing, suitable for late-night travel.",
                detail = "If you need to cross the border very late or very early, buses via Huanggang are usually the most reliable option."
            )
        } else {
            Recommendation(
                name = "Shenzhen Bay Port",
                summary = "Good choice for bus or car during daytime.",
                detail = "Direct buses to Hong Kong Island / Kowloon. Try to avoid just before long holidays; arrive slightly earlier than usual."
            )
        }
    } else {
        if (hour in 7..9 || hour in 17..19) {
            Recommendation(
                name = "Futian Port",
                summary = "Best for peak-hour MTR commuters.",
                detail = "Connected to MTR East Rail Line; compared with Lo Wu, passenger flow is more balanced and换乘更方便。"
            )
        } else {
            Recommendation(
                name = "Lo Wu",
                summary = "Classic and straightforward MTR route.",
                detail = "Suitable when it is not peak hour. Trains are frequent and signage is clear for both directions."
            )
        }
    }
}
