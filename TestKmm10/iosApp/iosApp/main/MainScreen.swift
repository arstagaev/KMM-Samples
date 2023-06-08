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
    @State private var newCity: String = ""
    
    
    var body: some View {
        
        ScrollView {
                        //BackgroundView()
            if(viewModel.viewState?.success != nil){
                let weather = viewModel.viewState?.success
                VStack(alignment: .center, spacing: 12) {
                    Text("Weather Forecast \nplease choose city:")
                    AsyncImage(url: URL(string: (weather?.condition.icon)!)) { image in
                        image.resizable()
                            .aspectRatio(contentMode: .fit)
                            .frame(maxWidth: 100, maxHeight: 100)
                    }placeholder: {
                                            ProgressView()
                    }
                    Spacer().frame(height: 50)
                    TextField("Enter city name", text: $newCity).frame(height: 60).background(Color.gray.opacity(0.3)).padding(10)
                    Button(action: {
                        async {
                            await viewModel.getWeather(city: newCity)
                        }
                        
                    }) {
                        Text("Request forecast")
                    }.buttonStyle(.bordered).tint(.pink)
                    
//                    if !newCity.isEmpty {
//                       Text("My City: \(newCity)!")
//                    }
                    Text("Success forecast:")
                    Text("Location:  \(weather?.name ?? "NaN")  \(weather?.country ?? "NaN") ")
                    Text("Temp: \(Int(weather?.feelslike_c ?? -999) )")
                    Text("Local time: \(weather?.localtime ?? "NaN")" )
                    
                    
                    
                }
              
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

