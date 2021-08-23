package com.sample.framework.mvvm.java.base;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.sample.framework.mvvm.java.network.api.ApiClient;
import com.sample.framework.mvvm.java.network.repository.HomeRepository;
import com.sample.framework.mvvm.java.ui.viewmodels.HomeViewModel;

/**
 * Add methods to get view models from this ViewModel Provider Factory Class.
 */
public class ViewModelProviderFactory {

    BaseActivity<?, ?> baseActivity;

    public ViewModelProviderFactory(BaseActivity<?, ?> baseActivity) {
        this.baseActivity = baseActivity;
    }

    /**
     * @return HomeViewModel
     */
    public HomeViewModel getHomeViewModel() {
        Supplier<HomeViewModel> supplier = () -> new HomeViewModel(baseActivity.getApplicationContext());
        ViewModelFactory<HomeViewModel> factory = new ViewModelFactory<>(HomeViewModel.class, supplier);
        return new ViewModelProvider(baseActivity, factory).get(HomeViewModel.class);
    }



}
