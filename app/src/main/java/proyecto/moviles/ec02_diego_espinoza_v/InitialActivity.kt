package proyecto.moviles.ec02_diego_espinoza_v

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import proyecto.moviles.ec02_diego_espinoza_v.databinding.ActivityInitialBinding

class InitialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInitialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityInitialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Mapa())

        binding.btnNavegacion.setOnItemSelectedListener {
            when(it.itemId){
                R.id.mapa -> replaceFragment(Mapa())
                R.id.camara -> replaceFragment(Camara())
                R.id.info -> replaceFragment(Informacion())

                else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.frame.id,fragment)
        fragmentTransaction.commit()
    }
}