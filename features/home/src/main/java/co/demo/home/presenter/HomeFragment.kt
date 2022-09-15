package co.demo.home.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import co.demo.core.domain.model.LoanAccountDetails
import co.demo.core.util.autoCleared
import co.demo.core.util.currencyFormat
import co.demo.home.R
import co.demo.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var binding by autoCleared<FragmentHomeBinding>()
    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var viewState: ViewState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            val param = it.getString(ARG_STATE)
            viewState = ViewState.valueOf(param.toString())
        }

        //  viewModel.getLoanAccountDetails(viewState)

        // Start a coroutine in the lifecycle scope
        lifecycleScope.launch {
            viewModel.loanAccountDetails.flowWithLifecycle(lifecycle).collect { accountDetails ->
                updateUI(accountDetails)
            }
        }
    }

    private fun updateUI(accountDetails: LoanAccountDetails) {
        when (viewState) {
            ViewState.New -> {
                binding.applyLoanCard.visibility = View.VISIBLE
                binding.dueLoanCard.visibility = View.GONE
                binding.loanStatusTitle.text = getString(R.string.apply_for_a_loan)
                val repayPrompt = getString(
                    R.string.repay_on_time_to_get_loans_up_to,
                    accountDetails.country?.loanLimit?.currencyFormat(accountDetails.country!!.currency)
                )
                binding.loanStatusSubtitle.text =
                    HtmlCompat.fromHtml(repayPrompt, HtmlCompat.FROM_HTML_MODE_COMPACT)
                binding.progressText.text = getString(R.string.track_your_progress_over_time)

                when (viewModel.getCountry()) {
                    "ke" -> {
                        binding.storyBg.setImageResource(R.drawable.img_story_card_ke)
                    }
                    "ph" -> {
                        binding.storyBg.setImageResource(R.drawable.img_story_card_ph)
                    }
                    "mx" -> {
                        binding.storyBg.setImageResource(R.drawable.img_story_card_mx)
                    }
                }
            }
            ViewState.Approved -> {
                binding.imgLoanStatus.setImageResource(R.drawable.img_loan_status_approved)
                binding.loanStatusTitle.text = getString(R.string.your_application_is_approved)
                accountDetails.loanData?.loan?.approved?.let {
                    binding.loanStatusSubtitle.text =
                        getString(
                            R.string.approved_amount,
                            it.toString().currencyFormat(accountDetails.country?.currency!!)
                        )
                }
                binding.applyLoanBtn.text = getString(R.string.view_loan_offer)
                binding.badge.setImageResource(R.drawable.img_bronze_badge_large)
                binding.progressText.text =
                    getString(
                        R.string.grow_your_limit_up_to_s,
                        accountDetails.country?.loanLimit.currencyFormat(accountDetails.country?.currency!!)
                    )
            }
            ViewState.Due -> {
                binding.applyLoanCard.visibility = View.GONE
                binding.dueLoanCard.visibility = View.VISIBLE
                accountDetails.loanData?.loan?.due?.let {
                    binding.loanAmountDue.text =
                        getString(
                            R.string.amount_due,
                            accountDetails.loanData?.loan?.due.toString()
                                .currencyFormat(accountDetails.country?.currency!!)
                        )
                }
                binding.applyLoanBtn.text = getString(R.string.view_loan_offer)
                binding.badge.setImageResource(R.drawable.img_bronze_badge_large)
                binding.progressText.text =
                    getString(
                        R.string.grow_your_limit_up_to_s,
                        accountDetails.country?.loanLimit.currencyFormat(accountDetails.country?.currency!!)
                    )
            }
            ViewState.Paid -> {
                binding.applyLoanCard.visibility = View.VISIBLE
                binding.dueLoanCard.visibility = View.GONE
                binding.imgLoanStatus.setImageResource(R.drawable.img_loan_status_paidoff)
                binding.loanStatusTitle.text = getString(R.string.fully_paid)
                binding.loanStatusSubtitle.text = getString(R.string.apply_another_loan)
                binding.applyLoanBtn.text = getString(R.string.view_loan_offer)
                binding.progressText.text =
                    getString(
                        R.string.grow_your_limit_up_to_s,
                        accountDetails.country?.loanLimit.currencyFormat(accountDetails.country?.currency!!)
                    )

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        const val ARG_STATE = "state"

        @JvmStatic
        fun newInstance(viewState: ViewState) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_STATE, viewState.state)
                }
            }
    }

}