//
//  MainViewModel.swift
//  iosApp
//
//  Created by Arsen Tagaev on 03.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension MainScreen {
    @MainActor class MainViewModel: ObservableObject {
//        private var useCase = GetWeatherByCityUseCase.invoke(GetWeatherByCityUseCase.init())
//        private var useCase2 = GetWeatherByCityUseCase()
        
        
        private var currentForecast = "cf"
        @Published private(set) var nowForecast = "NF"
//        @Published var city = "" {
//            didSet {
//
//            }
//        }
        @Published var viewState: MainState?
        @Published private (set) var str: String = "none"
        @Published private (set) var isLoading: Bool = true
            
        
        init(){
            
            async {
                await getWeather(city: "rennes")
            }
            
            
        }
        
        
        func getWeather(city: String) async {
            await GetWeatherByCityUseCase().invoke(parameter: city) { result, error in
                if result != nil {
                    self.viewState = MainState.init(isLoading: false, error: nil, success: result) //.HasResult(weather: weather)
                } else {
                    self.viewState = MainState.init(isLoading: false, error: "Error!!!", success: nil)
                }
            }
        }
    }
}
