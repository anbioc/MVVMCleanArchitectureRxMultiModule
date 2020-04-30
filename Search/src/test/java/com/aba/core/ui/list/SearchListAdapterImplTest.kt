package com.aba.core.ui.list

import android.widget.FrameLayout
import com.aba.core.SOME_SEARCH_MODELS
import com.aba.core.base.RobolectricTestBase
import junit.framework.Assert.assertNotNull
import org.assertj.android.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks
import org.robolectric.RuntimeEnvironment

class SearchListAdapterImplTest: RobolectricTestBase() {



    @Mock
    lateinit var mockCallback: SearchListAdapter.SearchAdapterCallback
    @Mock
    lateinit var mockViewHolder: SearchItemViewHolder
    private lateinit var subject: SearchListAdapterImpl
    private lateinit var viewHolder: SearchItemViewHolder

    @Before
    fun setup(){
        initMocks(this)
        subject = SearchListAdapterImpl(mockCallback)
    }


    @Test
    fun `whenOnCreateViewHolder thenViewHolderIsCreated`(){
        whenOnCreateViewHolder()
        thenViewHolderIsCreated()
    }

    @Test
    fun `givenSearchItems whenOnBindViewHolder thenViewHolderBindViewIsCalled`(){
        givenSearchItems()
        whenOnBindViewHolder()
        thenViewHolderBindViewIsCalled()
    }



    /*
     * Given
     */
    private fun givenSearchItems() {
        subject.searchItems = SOME_SEARCH_MODELS
    }


    /*
     * When
     */
    private fun whenOnCreateViewHolder() {
        viewHolder = subject.createViewHolder(FrameLayout(RuntimeEnvironment.application), 0)
    }

    private fun whenOnBindViewHolder() {
        subject.onBindViewHolder(mockViewHolder, 0)
    }

    /*
     * Then
     */
    private fun thenViewHolderIsCreated() {
        assertNotNull(viewHolder)
    }

    private fun thenViewHolderBindViewIsCalled() {

    }

}