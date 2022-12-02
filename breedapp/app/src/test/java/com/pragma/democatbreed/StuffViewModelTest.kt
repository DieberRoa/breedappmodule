package com.pragma.democatbreed

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.pragma.democatbreed.features.breeds.usecases.StuffDataBusiness
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class StuffViewModelTest {

    @get:Rule
    val testInstanceTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var stuffDataBusiness: StuffDataBusiness

    @Mock
    private lateinit var messageObserver: Observer<String>
    @Mock
    private lateinit var listObserver: Observer<List<Stuff>?>

    @InjectMocks
    lateinit var stuffViewModel: StuffViewModel

    @Before
    fun setUp() {

    }

    @Test
    fun whenApiGetAEmptyListTheViewModelShowMessageEmptyList() {
        testCoroutineRule.runBlockingTest {
            doReturn(ResponseGetStuffs(emptyList<Stuff>(), Operation("","")))
                .`when`(stuffDataBusiness).invoke()
            stuffViewModel.showMessage.observeForever(messageObserver)
            stuffViewModel.loadData()
            verify(stuffDataBusiness).invoke()
            verify(messageObserver).onChanged("Vacio")
            stuffViewModel.showMessage.removeObserver(messageObserver)
        }
    }

    @Test
    fun whenApiGetAFillListTheViewModelShowTheList() {
        var stuffs : List<Stuff> = createFilledStuffList()
        testCoroutineRule.runBlockingTest {
            doReturn(ResponseGetStuffs(stuffs, Operation("","")))
                .`when`(stuffDataBusiness).invoke()
            stuffViewModel.data.observeForever(listObserver)
            stuffViewModel.loadData()
            verify(stuffDataBusiness).invoke()
            verify(listObserver).onChanged(stuffs)
            stuffViewModel.data.removeObserver(listObserver)
        }
    }

    @Test
    fun mustExistTheViewModelClass() {
        assertThat(stuffViewModel, instanceOf(StuffViewModel::class.java))
    }

    private fun createFilledStuffList() : List<Stuff> {
        var stuffs: MutableList<Stuff> = mutableListOf<Stuff>()
        for (num in 1..10){
            stuffs.add(Stuff(num, "Name_$num", 0))
        }
        return stuffs
    }

}