//
//  MainScreen.swift
//  iosApp
//
//  Created by Arsen Tagaev on 03.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MainScreen: View {
    
    @StateObject var viewModel = MainViewModel()
    
    var body: some View {
        Text("Pizdec")
        
        ZStack {
                        //BackgroundView()
            if(viewModel.viewState?.success != nil){
                let weather = viewModel.viewState?.success
                VStack {
                    Text("Weather +++" + (weather?.country)!)
                    Text("Weather +++" + (weather?.name)!)
                    Text("Weather +++ \(weather?.feelslike_c ?? -999)" )
                }
                
//                            WeatherDescriptionView(
//                                txt: successState.success?.country
//                            )
            } else if(viewModel.viewState?.error != nil){
                
                Text("Error ><. " + (viewModel.viewState?.error ?? "piz error")!)

            } else if (viewModel.viewState?.isLoading == true){
                            Text("Loading...")
            }
        }
    }
//    let gridColumns: [GridItem] = Array(repeating: GridItem(.flexible(), spacing: 16), count: 2)
//
//    var body: some View {
//        Text("Hi")
//        NavigationStack {
//            ScrollView {
//                LazyVGrid(columns: gridColumns, spacing: 16) {
//                    ForEach(viewModel.animes, id: \.id) { anime in
//                        NavigationLink(value: anime) {
//                            AnimeItem(anime: anime)
//                        }.buttonStyle(PlainButtonStyle())
//                    }
//                    if viewModel.isLoading {
//                        Section(footer: ProgressView()) { }
//                    }
//                }
//                .padding(.horizontal,12)
//                .navigationDestination(for: Anime.self) { anime in
//                    DetailScreen(anime: anime)
//                }
//            }.navigationTitle("Anime Characters")
//        }.task {
//            await viewModel.getAllCharacters()
//        }
//  }
}

