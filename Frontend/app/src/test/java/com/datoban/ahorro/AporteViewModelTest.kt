import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import com.datoban.ahorro.domain.repository.AhorroRepository
import com.datoban.ahorro.presentacion.viewmodel.AporteViewModel
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AporteViewModelTest {

    private val repository = mockk<AhorroRepository>(relaxed = true)

    private lateinit var viewModel: AporteViewModel

    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {

        Dispatchers.setMain(dispatcher)

        viewModel = AporteViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun registrarAporte_debeLlamarRepository() = runTest {

        viewModel.registrarAporte(
            metaId = 1,
            miembroId = 2,
            monto = 200000.0,
            metodoPago = "Nequi",
            descripcion = "Pago prueba"
        )

        dispatcher.scheduler.advanceUntilIdle()

        coVerify {
            repository.registrarAporte(any())
        }

    }

}