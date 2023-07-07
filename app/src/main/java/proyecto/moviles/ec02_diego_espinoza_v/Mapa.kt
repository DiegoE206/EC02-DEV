package proyecto.moviles.ec02_diego_espinoza_v

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import proyecto.moviles.ec02_diego_espinoza_v.databinding.FragmentMapaBinding


class Mapa : Fragment() {
    private lateinit var binding: FragmentMapaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            val map1 = Uri.parse("geo:0,0?q=-12.155762217189016, -76.94352184883749(Casa)")
            val intent = Intent(Intent.ACTION_VIEW, map1)
            intent.setPackage("com.google.android.apps.maps")
            intent.resolveActivity(requireActivity().packageManager)?.let {
                startActivity(intent)
            }
        }

        binding.btn2.setOnClickListener {
            val map2 = Uri.parse("geo:0,0?q=-12.093995122956294, -77.02482418586801(Trabajo)")
            val intent = Intent(Intent.ACTION_VIEW, map2)
            intent.setPackage("com.google.android.apps.maps")
            intent.resolveActivity(requireActivity().packageManager)?.let {
                startActivity(intent)
            }
        }

        binding.btn3.setOnClickListener {
            val map3 = Uri.parse("geo:0,0?q=-12.136817293154975, -76.9864764186494(Parque Loma Amarrilla)")
            val intent = Intent(Intent.ACTION_VIEW, map3)
            intent.setPackage("com.google.android.apps.maps")
            intent.resolveActivity(requireActivity().packageManager)?.let {
                startActivity(intent)
            }
        }
    }
}