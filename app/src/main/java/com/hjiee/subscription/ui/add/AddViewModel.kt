package com.hjiee.subscription.ui.add

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.hjiee.base.BaseViewModel
import com.hjiee.subscription.data.local.db.SubscriptionEntity
import com.hjiee.subscription.data.local.db.convertToSubscriptionEntity
import com.hjiee.subscription.data.repository.AddRepository
import com.hjiee.subscription.ui.AppApplication.Companion.DATABASE_NAME
import com.hjiee.util.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import timber.log.Timber

class AddViewModel @ViewModelInject constructor(
    private val addRepository: AddRepository
) : BaseViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val firestore by lazy { FirebaseFirestore.getInstance() }
    lateinit var lastVisible: DocumentSnapshot

    private val _items = MutableLiveData<List<SubscriptionEntity>>()
    val items : LiveData<List<SubscriptionEntity>> get() = _items

    private val _total = MutableLiveData<Int>()
    val total : LiveData<Int> get() = _total

    val isSubscribed = SingleLiveEvent<Boolean>()

    fun load() {
        firestore.collection(DATABASE_NAME)
            .limit(30)
            .get()
            .addOnSuccessListener { documentSnapshot ->
                // 파이어베이스 페이징
                if(documentSnapshot.size() >= 1) {
                    lastVisible = documentSnapshot.documents[documentSnapshot.size() - 1]
                }
                val temp = mutableListOf<SubscriptionEntity>()
                for (i in documentSnapshot.documents.indices) {
                    _total.value = documentSnapshot.documents.indices.last
                    convertToSubscriptionEntity(documentSnapshot.documents[i].data)?.let {
                        temp.add(it)
                    }
                }
                _items.value = temp
            }
            .addOnFailureListener {
                Timber.tag("firebase").w("$it")
            }
    }

    fun subscribe(item : SubscriptionEntity) {
        addRepository.insert(item)
            .subscribe(
                {
                    isSubscribed.call(true)
                },
                {

                }
            ).addTo(compositeDisposable)
    }

    fun write() {
//        firestore.collection(DATABASE_NAME).document("Youtube-1").set(SubscriptionModel(product = "Youtube",title = "Youtube Premium", price = 8690f, type = SubscriptionType.PERIODIC, isPopular = true, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("iCloud-1").set(SubscriptionModel(product = "iCloud",title = "iCloud 50GB", price = 1100f, type = SubscriptionType.PERIODIC, isPopular = true, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("iCloud-2").set(SubscriptionModel(product = "iCloud",title = "iCloud 200GB", price = 3300f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("iCloud-3").set(SubscriptionModel(product = "iCloud",title = "iCloud 2TB", price = 11100f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Melon-1").set(SubscriptionModel(product = "Melon",title = "스트리밍 플러스", price = 10900f, type = SubscriptionType.PERIODIC, isPopular = true, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Melon-2").set(SubscriptionModel(product = "Melon",title = "HI-FI 스트리밍 클럽", price = 12000f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Melon-3").set(SubscriptionModel(product = "Melon",title = "스트리밍 클럽", price = 7900f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Melon-4").set(SubscriptionModel(product = "Melon",title = "모바일 스트리밍 클럽", price = 6900f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Melon-5").set(SubscriptionModel(product = "Melon",title = "MP3 30 플러스", price = 16000f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Melon-6").set(SubscriptionModel(product = "Melon",title = "MP3 50 플러스", price = 19000f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Melon-7").set(SubscriptionModel(product = "Melon",title = "MP3 100 플러스", price = 28000f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Melon-8").set(SubscriptionModel(product = "Melon",title = "MP3 30", price = 12000f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Melon-9").set(SubscriptionModel(product = "Melon",title = "MP3 50", price = 15000f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Melon-10").set(SubscriptionModel(product = "Melon",title = "MP3 100", price = 24000f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Melon-11").set(SubscriptionModel(product = "Melon",title = "프리클럽", price = 14900f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Melon-12").set(SubscriptionModel(product = "Melon",title = "어학 프리클럽", price = 5000f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Melon-13").set(SubscriptionModel(product = "Melon",title = "어학 스트리밍 클럽", price = 3000f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Netflix-1").set(SubscriptionModel(product = "Netflix",title = "베이식", price = 9500f, type = SubscriptionType.PERIODIC, isPopular = true,paymentUrl = "https://www.netflix.com/signup/planform"), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Netflix-2").set(SubscriptionModel(product = "Netflix",title = "스탠다드", price = 12000f, type = SubscriptionType.PERIODIC, isPopular = true,paymentUrl = "https://www.netflix.com/signup/planform"), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Netflix-3").set(SubscriptionModel(product = "Netflix",title = "프리미엄", price = 14500f, type = SubscriptionType.PERIODIC, isPopular = true,paymentUrl = "https://www.netflix.com/signup/planform"), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Dropbox-1").set(SubscriptionModel(product = "Dropbox",title = "Professional (3T)", price = 22200f, type = SubscriptionType.PERIODIC, isPopular = true, paymentUrl = "https://www.dropbox.com/business/plans-comparison", imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Dropbox-2").set(SubscriptionModel(product = "Dropbox",title = "Standard (5T)", price = 16650f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = "https://www.dropbox.com/business/plans-comparison", imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("Dropbox-3").set(SubscriptionModel(product = "Dropbox",title = "Advanced", price = 27750f, type = SubscriptionType.PERIODIC, isPopular = false, paymentUrl = "https://www.dropbox.com/business/plans-comparison", imageUrl = null), SetOptions.merge())

//        firestore.collection(DATABASE_NAME).document("").set(SubscriptionModel(product = "",title = "", price = 0f, type = SubscriptionType.PERIODIC, isPopular = true, paymentUrl = null, imageUrl = null), SetOptions.merge())
//        firestore.collection(DATABASE_NAME).document("").set(SubscriptionModel(product = "",title = "", price = 0f, type = SubscriptionType.PERIODIC, isPopular = true, paymentUrl = null, imageUrl = null), SetOptions.merge())

    }
}