package com.example.sunmusic.data.executor

import com.example.sunmusic.utils.Constant
import com.example.sunmusic.utils.extension.logDebugApp
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory
import kotlin.LazyThreadSafetyMode.SYNCHRONIZED

interface AppExecutor {
    fun executes(vararg runables: Runnable?)
}

class AppExecutorImpl private constructor(nThread: Int) : Executor, AppExecutor {
    private val mExecutor = Executors.newFixedThreadPool(nThread, MyThreadFactory())

    companion object {
        val instance by lazy(SYNCHRONIZED) { AppExecutorImpl(Constant.MAX_THREAD) }
    }

    override fun execute(p0: Runnable?) {
        mExecutor.execute(p0)
        logDebugApp(p0?.toString() ?: "")
    }

    override fun executes(vararg runables: Runnable?) {
        runables.forEach { execute(it) }
    }

    class MyThreadFactory : ThreadFactory {
        private var count = 0
        override fun newThread(p0: Runnable?): Thread {
            return Thread(p0, "${Constant.APP_ID} - Thread - ${count++}")
        }
    }
}