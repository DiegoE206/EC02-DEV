package proyecto.moviles.ec02_diego_espinoza_v

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import proyecto.moviles.ec02_diego_espinoza_v.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.email.editText?.addTextChangedListener { text ->
            binding.btnLogear.isEnabled = validateEmailPass(text.toString(), binding.password.editText?.text.toString())
        }

        binding.password.editText?.addTextChangedListener { text ->
            binding.btnLogear.isEnabled = validateEmailPass(binding.email.editText?.text.toString(), text.toString())
        }

        binding.btnLogear.setOnClickListener {
            val InitialVentana = Intent(this, InitialActivity::class.java)
            startActivity(InitialVentana)
            Toast.makeText(this, "Bienvenido Uusario", Toast.LENGTH_SHORT).show()
        }

    }

    private fun validateEmailPass(email: String, pass: String): Boolean {
        val validateEmail = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches() && email == "ejemplo@idat.edu.pe"
        val validatePass = pass.isNotEmpty() && pass == "123456"
        return validateEmail && validatePass
    }

}