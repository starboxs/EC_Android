package com.example.marco.ec_android.news;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marco.ec_android.R;
import com.trello.rxlifecycle.components.RxFragment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.ButterKnife;

public class newsInformationFragment extends RxFragment implements Html.ImageGetter {

    private newsInformationFragment.OnFragmentInteractionListener listener;
    TextView tvTitle;
    TextView tvDesc;
    String title = "從東亞運到85度C，中國有完沒完？";
    String desc = "<img style='width:100%' alt=主席放送局 class=left src=http://radicalwings.tw/upload/images/_2.jpg style=float:left; height:200px; width:200px/>" +
            "\n" +
            "<h4><span style=\"font-family:courier new,courier,monospace\"><strong><span style=\"color:#008080\">在保守的台灣，若要完成「國家打造」此一使命，催生出比民進黨更為本土的第二本土政黨，是此一典範轉移的重要歷史要件之一。因此，基進在2018年此戰，有著重大的意義。畢竟，若能讓台灣政治競爭場域中，有著民進黨之外的另一支更獨、更本土以及更公義的政黨，透由二者的競爭，方能讓政治統獨光譜與政治辯論主軸，往新國家與新共和完成的方向逐步挺進。</span></strong></span></h4>\n" +
            "\n" +
            "<p>　　</p>\n" +
            "\n" +
            "<p>　　基進之友平安！</p>\n" +
            "\n" +
            "<p>　　2018年11月24日的九合一地方選舉，基進黨在雙北、台南跟高雄推出共十三名優秀的候選人參選。由於，基進是欠缺各種資源的微型政黨，因此亟需基友的各種奧援跟幫忙，方能成功挺過此次選舉，入政市議會。</p>\n" +
            "\n" +
            "<p>　　誠如過往所言，在保守的台灣，若要完成「國家打造」此一使命，催生出比民進黨更為本土的第二本土政黨，是此一典範轉移的重要歷史要件之一。因此，基進在2018年此戰，有著重大的意義。畢竟，若能讓台灣政治競爭場域中，有著民進黨之外的另一支更獨、更本土以及更公義的政黨，透由二者的競爭，方能讓政治統獨光譜與政治辯論主軸，往新國家與新共和完成的方向逐步挺進。</p>\n" +
            "\n" +
            "<p>　　過去，李登輝嘗試推動中國國民黨的本土化工程，以本土國民黨跟本土民進黨競爭的政治想像，在兩千年之後，隨著李登輝被驅逐出國民黨，導致國民黨本土化進程的反挫，讓台灣政治陷入「藍綠」的分野對抗中。若要「超克藍綠」，唯有斬斷外來意義的「藍」，並隨著藍的消解過程中，催生出另一支更為本土公義獨派的深綠，此時「綠」作為「本土」的象徵便自然消失，而「『超克』藍綠」的工程，也將自動完成。基進打從2013年開始組建伊始，便是在此一「宏觀政略」的指導下組織跟行動。</p>\n" +
            "\n" +
            "<p>　　再者，端就基層政治的現況而言，以選舉遊戲規則的方式作為政治改革的推動，當前由金錢、固化的樁腳系統，以及令人失望的政治所可能導致的低投票率，在在已讓定期選舉作為政治改革推動器的動能，相當程度的被「耗盡」。職是之故，姑不論催生新國家此一中長期的本土議程跟目標，台灣基層政治的結構性惰性，往往讓政治結果不僅悖離人民需求，更成為某種「掠奪性」的存在。因此，唯有讓不同於過往政治體制跟結構的優質政治工作者，用一種不同於以往的方式「入政」，才能打破當前已經僵化的政治結構，及此結構所堆砌出來的「門檻」，讓優秀的人才能親近政治、更有機會成為代議士。</p>\n" +
            "\n" +
            "<p>　　換言之，不靠明星光環、不靠固化樁腳利益選票基礎、不靠花錢大撒幣的方式的微型政黨基進的入政，便有著砲轟當前政治結構與體制的叩關意義。此乃為何，縱使基進黨可能是各黨派候選人平均年齡最年輕之政黨，卻不以販賣空洞的新世代之「青春肉體」為口號，畢竟在年輕政二代紛紛出籠的狀況下，新世代的青春肉體的較勁是沒有意義的。這是基進打出「讓政治可及，讓城市可親」的主要內涵意義。因為，我們要把此一「有選舉投票權」，但看得到卻吃不到的「被選舉權」的結構打破並奪回屬於人民的「完整參政權」！！</p>\n" +
            "\n" +
            "<p>　　最後，選舉一到，牽涉到既得利益的存續或消長，於是，各種流言蜚語定當層出不窮，各種不實抹黑，也將隨著新興網路媒介而大行其道。因此，散布海內外的基友，若有聽到各種對基進的胡亂抹黑與流言，還煩請能主動幫忙澄清，抑或跟基進的幹部或黨部聯繫，若情節過重者，我們定當採取法律途徑，不能讓帶著惡意的流言繼續散播。</p>\n" +
            "\n" +
            "<p>　　還是老話一句，基進的各位夥伴們，不論您人身處何地，若在工作之外有各種餘力，希望能一起出來幫忙，用各種方式幫忙基進全體的這一場戰鬥，這一場肩負台灣新國家打造過程中，具備歷史性意義的戰鬥啊！！</p>\n" +
            "\n" +
            "<div style=\"display:block; width:90px;\"><img style='width:100%' alt=\"基進之友\" src=\"http://radicalwings.tw/upload/images/logo.gif\" style=\"height:90px; width:90px\" />";


    public static newsInformationFragment newInstance() {
        return new newsInformationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_news_information, container, false);
        ButterKnife.bind(this, v);
        tvTitle = (TextView) v.findViewById(R.id.newsInfoTitle);
        tvDesc = (TextView) v.findViewById(R.id.newsInfoData);
        tvTitle.setText(Html.fromHtml(title));
        Spanned spanned = Html.fromHtml(desc, this, null);
        tvDesc.setText(spanned);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof newsInformationFragment.OnFragmentInteractionListener) {
            listener = (newsInformationFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public Drawable getDrawable(String source) {

        LevelListDrawable d = new LevelListDrawable();
        Drawable empty = getResources().getDrawable(R.drawable.selector_primary);
        d.addLevel(0, 0, empty);
        d.setBounds(0, 0, empty.getIntrinsicWidth(), empty.getIntrinsicHeight());

        new LoadImage().execute(source, d);

        return d;
    }

    public interface OnFragmentInteractionListener {
    }


    class LoadImage extends AsyncTask<Object, Void, Bitmap> {

        private LevelListDrawable mDrawable;

        @Override
        protected Bitmap doInBackground(Object... params) {
            String source = (String) params[0];
            mDrawable = (LevelListDrawable) params[1];
            try {
                InputStream is = new URL(source).openStream();
                return BitmapFactory.decodeStream(is);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {

            if (bitmap != null) {
                BitmapDrawable d = new BitmapDrawable(bitmap);
                mDrawable.addLevel(1, 1, d);
                mDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                mDrawable.setLevel(1);
                // i don't know yet a better way to refresh TextView
                // mTv.invalidate() doesn't work as expected
                CharSequence t = tvDesc.getText();
                tvDesc.setText(t);
            }
        }
    }

}
