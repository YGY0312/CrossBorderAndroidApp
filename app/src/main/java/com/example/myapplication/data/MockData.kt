package com.example.myapplication.data

import com.example.myapplication.model.BorderCheckpoint

object MockData {
    val borderCheckpoints = listOf(
        BorderCheckpoint(
            name = "Futian Port / 福田口岸",
            cityPair = "Shenzhen ↔ Hong Kong",
            note = "MTR East Rail Line to Lok Ma Chau",
            openHours = "06:30 - 22:30",
            transport = listOf("MTR")
        ),
        BorderCheckpoint(
            name = "Lo Wu / 罗湖口岸",
            cityPair = "Shenzhen ↔ Hong Kong",
            note = "Classic crossing via MTR East Rail Line",
            openHours = "06:30 - 23:59",
            transport = listOf("MTR")
        ),
        BorderCheckpoint(
            name = "Lok Ma Chau Spur Line / 落马洲支线",
            cityPair = "Shenzhen ↔ Hong Kong",
            note = "Linked with Futian Port",
            openHours = "06:30 - 22:30",
            transport = listOf("MTR")
        ),
        BorderCheckpoint(
            name = "Huanggang Port / 皇岗口岸",
            cityPair = "Shenzhen ↔ Hong Kong",
            note = "24-hour shuttle bus to Lok Ma Chau",
            openHours = "00:00 - 23:59",
            transport = listOf("Bus")
        ),
        BorderCheckpoint(
            name = "Shenzhen Bay Port / 深圳湾口岸",
            cityPair = "Shenzhen ↔ Hong Kong",
            note = "Bus and private car crossing",
            openHours = "06:30 - 24:00",
            transport = listOf("Bus", "Car")
        ),
        BorderCheckpoint(
            name = "Wenjindu Port / 文锦渡口岸",
            cityPair = "Shenzhen ↔ Hong Kong",
            note = "Cross-border buses and cargo transport",
            openHours = "07:00 - 22:00",
            transport = listOf("Bus")
        ),
        BorderCheckpoint(
            name = "Liantang Port / 莲塘口岸",
            cityPair = "Shenzhen ↔ Hong Kong",
            note = "Heung Yuen Wai Port; cross-border buses",
            openHours = "07:00 - 22:00",
            transport = listOf("Bus")
        ),
        BorderCheckpoint(
            name = "West Kowloon High-Speed Rail / 香港西九龙高铁站",
            cityPair = "Shenzhen North / Futian ↔ Hong Kong",
            note = "High-Speed Rail connection",
            openHours = "06:30 - 23:00",
            transport = listOf("HSR")
        ),
        BorderCheckpoint(
            name = "Shekou Ferry Terminal / 蛇口邮轮中心",
            cityPair = "Shenzhen ↔ Central / Tsim Sha Tsui",
            note = "Direct ferry services",
            openHours = "08:00 - 21:30",
            transport = listOf("Ferry")
        ),
        BorderCheckpoint(
            name = "Fuyong Ferry Terminal / 福永码头",
            cityPair = "Shenzhen ↔ HKIA SkyPier",
            note = "Ferry to Hong Kong Airport",
            openHours = "07:00 - 20:00",
            transport = listOf("Ferry")
        )
    )
}
