package br.com.caiogandra.carcatalog.carlist.viewmodel

import android.view.View
import br.com.caiogandra.carcatalog.base.BaseView
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.carlist.view.CarListView
import br.com.caiogandra.carcatalog.datasource.car.CarRepository
import br.com.caiogandra.carcatalog.model.Car
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
class CarListViewModelTest {

    val carRepository: CarRepository = mock()
    val view: CarListView = mock()

    lateinit var viewModel: CarListViewModel

    @Before
    fun setup() {
        viewModel = CarListViewModel(carRepository, view)
    }

    @Test
    fun getListVisibility_NoCars_AssertViewGone() {
        //arrange
        //not necessary

        //act
        val visibility = viewModel.getListVisibility()

        //assert
        Assert.assertEquals(visibility, View.GONE)
    }

    @Test
    fun getListVisibility_OneCar_AssertViewVisible() {
        //arrange
        val cars = ArrayList<Car>()
        cars.add(Car())
        viewModel.cars = cars

        //act
        val visibility = viewModel.getListVisibility()

        //assert
        Assert.assertEquals(visibility, View.VISIBLE)
    }

    @Test
    fun getEmptyWarningVisibility_NoCars_AssertViewVisible() {
        //arrange
        //not necessary

        //act
        val visibility = viewModel.getEmptyWarningVisibility()

        //assert
        Assert.assertEquals(visibility, View.VISIBLE)
    }

    @Test
    fun getEmptyWarningVisibility_OneCar_AssertViewGone() {
        //arrange
        val cars = ArrayList<Car>()
        cars.add(Car())
        viewModel.cars = cars

        //act
        val visibility = viewModel.getEmptyWarningVisibility()

        //assert
        Assert.assertEquals(visibility, View.GONE)
    }
}