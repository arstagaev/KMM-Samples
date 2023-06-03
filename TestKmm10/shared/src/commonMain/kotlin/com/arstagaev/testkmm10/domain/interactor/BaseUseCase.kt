package com.arstagaev.testkmm10.domain.interactor

interface BaseUseCase<in Parameter, out Result> {
    suspend operator fun invoke(parameter: Parameter): Result
}

interface ReceiverUseCase<out Result> {
    suspend operator fun invoke(): Result
}
