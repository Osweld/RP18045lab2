package com.example.rp18045lab2.ui.home

import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.MediaController
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rp18045lab2.R
import com.example.rp18045lab2.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var video:VideoView
    private lateinit var mediaController: MediaController
    private var gDetector: GestureDetector? = null
    private var isRunning:Boolean = false

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragment = inflater.inflate(R.layout.fragment_home, container, false)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        gDetector = GestureDetector(context, this)
        gDetector?.setOnDoubleTapListener(this)

//Relacionado con el video
        video= binding.videoView
        mediaController = MediaController(context)
        mediaController.setAnchorView(video)
        video.setMediaController(mediaController)
        video.setVideoURI(Uri.parse("android.resource://"+"com.example.rp18045lab2"+"/"+ R.raw.video))
        video.setOnTouchListener {
                _, event -> gDetector!!.onTouchEvent(event)
            true }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onShowPress(p0: MotionEvent?) {
        video.start()
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {

        return true
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {

        return true
    }

    override fun onLongPress(p0: MotionEvent?) {

    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {

        return true
    }

    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
   video.resume()
        return true
    }

    override fun onDoubleTap(p0: MotionEvent?): Boolean {

        return true
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
        video.pause()
        return true
    }
}