package com.example.myapplication.data

import com.example.myapplication.model.Route

object MockRouteData {
    val routes = listOf(
        Route(
            id = 1,
            name = "Futian Port → Admiralty",
            from = "Futian Port",
            to = "Admiralty",
            duration = "32 minutes",
            transport = "MTR East Rail Line → Transfer at Hung Hom",
            steps = listOf(
                "Enter Futian Port MTR Station",
                "Take the East Rail Line towards Hung Hom",
                "Arrive at Hung Hom and transfer to Tuen Ma Line",
                "Transfer to South Island Line at Ocean Park",
                "Arrive at Admiralty"
            )
        ),
        Route(
            id = 2,
            name = "Shenzhen Bay Port → Central",
            from = "Shenzhen Bay",
            to = "Central",
            duration = "45 minutes",
            transport = "Bus B3X → MTR",
            steps = listOf(
                "Take Bus B3X at Shenzhen Bay Port",
                "Arrive at Tuen Mun Station",
                "Take Tuen Ma Line to Hung Hom",
                "Transfer to Tsuen Wan Line",
                "Arrive at Central"
            )
        ),
        Route(
            id = 3,
            name = "Lo Wu → Mong Kok",
            from = "Lo Wu",
            to = "Mong Kok",
            duration = "28 minutes",
            transport = "MTR",
            steps = listOf(
                "Enter Lo Wu Station",
                "Take MTR East Rail Line towards Hung Hom",
                "Arrive at Mong Kok East",
                "Walk 8 minutes to Mong Kok MTR Station"
            )
        )
    )
}
