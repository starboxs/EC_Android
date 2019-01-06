package com.example.marco.ec_android.service;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.TextView;

import com.example.marco.ec_android.R;
import com.trello.rxlifecycle.components.RxFragment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.ButterKnife;

public class serviceInformationFragment extends RxFragment implements Html.ImageGetter {

    public String mServiceType = "1000";
    public Button mNewsReserviceBtn;
    TextView tvDesc;
    String desc;
    private serviceInformationFragment.OnFragmentInteractionListener listener;

    public static serviceInformationFragment newInstance() {
        return new serviceInformationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_service_information, container, false);
        ButterKnife.bind(this, v);
        mNewsReserviceBtn = v.findViewById(R.id.news_reservice);
        tvDesc = (TextView) v.findViewById(R.id.textView2);
        mNewsReserviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(serviceInformationFragment.this.getActivity(), serviceStep1Activity.class);
                startActivity(intent);
            }
        });
        Bundle bundle = getArguments();
        if (bundle != null) {
            int item = bundle.getInt("data");
            System.out.println("資料:" +item);
            mServiceType = item+"";
        }
        if (mServiceType.equals("1000")) {
            mNewsReserviceBtn.setText("預約居家清潔");
            desc = "<p dir=\"ltr\">\n" +
                    "    居家清潔\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    您是職業婦女嗎?您有打掃住家的困擾嗎?\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    終於下班了~進了家門，凌亂的客廳、佈滿灰塵的地板、小孩的玩具四處散落\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    我都忘了這個家原本裝潢後的感覺，是多麼的讓親朋好友羨煞\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    繁重的工作壓力 怎麼都無法從心頭抹去\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    實在好懶好懶再打起精神收拾這一切………\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    有了潔屋大師~無論客廳、臥室、衛浴及廚房，讓您的家居更清潔！交給潔屋大師就對了!\n" +
                    "</p>\n" +
                    "<br/>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    服務內容\n" +
                    "</p>\n" +
                    "<br/>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    客廳\n" +
                    "</p>\n" +
                    "<ul>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            櫃子擦淨\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            傢俱擦拭\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            雜物收納\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ul>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    地板\n" +
                    "</p>\n" +
                    "<ul>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            物品收拾\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            地板吸塵\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            拖地清掃\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ul>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    浴室\n" +
                    "</p>\n" +
                    "<ul>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            馬桶清洗\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            磁磚刷洗\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            鏡面光亮\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            浴盆清潔\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            檯面整理\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ul>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    廚房\n" +
                    "</p>\n" +
                    "<ul>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            排油煙機\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            爐具清理\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            牆面擦拭\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            櫃外擦淨\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            流理台清洗\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ul>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    廚房\n" +
                    "</p>\n" +
                    "<ul>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            觀景窗\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            一般窗戶\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            鏡面部份\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            窗溝清潔\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ul>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    臥室\n" +
                    "</p>\n" +
                    "<ul>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            衣櫃擦拭\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            被褥整理\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            床單更換\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ul>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    注意事項：\n" +
                    "</p>\n" +
                    "<ul>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            上為居家清潔之主要服務項目，更細部的則未詳述在內。\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            為保障客戶權益及個人隱私，櫥櫃內、門板內及抽屜內一律不擦拭。\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            窗戶及紗窗的拆卸極具公共危險性，故女性服務人員僅施作內面玻璃的擦拭。\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            居家清潔一律依鐘點計費，會盡可能的在時間內清掃，無法保證到全部都好。\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ul>";
        } else {
            mNewsReserviceBtn.setText("預約専業除蟎");
            desc = "<p dir=\"ltr\">\n" +
                    "    專業除螨\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    去蟎蟲更健康\n" +
                    "</p>\n" +
                    "<ul>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            看不見的塵蟎正是危害健康的隱形殺手!\n" +
                    "            來自世界各地的醫學研究顯示，導致與日俱增的哮喘、鼻敏感等病症，其主要元兇就是人類肉眼無法看見的塵蟎排泄物。\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            生活中最常見的蟎蟲就是塵蟎，它們多見於臥室內的枕頭，被褥，軟墊和家具中，還有那些枕邊的毛絨玩具。\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            塵蟎對人體影響最大的就是它的過敏症狀：塵蟎過敏性哮喘和過敏性鼻炎，還有人們最關心，也是表現明顯的塵蟎過敏性皮炎。\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            塵蟎寄生在室內的毛絨製品，以人的皮屑為食，在潮濕的環境更容易滋生。\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ul>\n" +
                    "<br/>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    除塵蟎必選潔屋大師3大理由\n" +
                    "</p>\n" +
                    "<ol>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            專業頂級設備\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ol>\n" +
                    "<ul>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            核心技術-利用每分鐘24000高速旋轉的分隔器，讓乾淨的空氣從污水中分隔出來，在沒有任何濾網狀態下空氣乾淨度高達99.997%。\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            强力拍打器-內置實心木滾轆附有4組拍打毛刷，獨立摩打每分鐘最高速轉動30,000轉，徹底將床褥深層的皮屑、致敏原，或地毯內的塵垢、寵物毛髮等，以強大的氣流送到Rainbow水濾系統內，令您的家具煥然一新。不會錯過任何污垢。\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            雙重潔淨-雙重過濾設計，確保Rainbow為您家居提供近100%潔淨空氣!獨特的水濾式設計能有效過濾99.997%家居塵(以重量計算)。配合Rainbow獨有HEPA高效微粒過濾系統，潔淨效能提高至更高層次。\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ul>\n" +
                    "<br/>\n" +
                    "<img\n" +
                    "    src=\"https://lh4.googleusercontent.com/QoiWDg92QN9sVdCcaPgrF6UiqBbCQgRGkKO4wDAa2D5Mrma3blEYfLNV7CDewlnpPeNFL6P49ivb6LzkerFtye2z9rWSMlRuV3OctLZQWbNgcZ7tk3Df9LnD_cKdayDwS_dUfCYrOU8HfQJ_ng\"\n" +
                    "    width=\"189\"\n" +
                    "    height=\"189\"\n" +
                    "/>\n" +
                    "<img\n" +
                    "    src=\"https://lh4.googleusercontent.com/PCNCW6-5kfP5LrWNqLbg3MH03q52nqy4FIS_HBj3yr5OZNXdfR0NLcvoJ6tEfISfE4rrkZOpe488V_9c8Dh17VYRVtLAeXuhOCNqwLaYAGiUxvepghze34JHhr_LXHsQPNBouHzAXevjAxosuQ\"\n" +
                    "    width=\"189\"\n" +
                    "    height=\"189\"\n" +
                    "/>\n" +
                    "<br/>\n" +
                    "<br/>\n" +
                    "<br/>\n" +
                    "<br/>\n" +
                    "<ol start=\"2\">\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            除螨效果立見\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ol>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    從原本透明清澈的水盆中，立即看出所攜出的塵螨，水濾式除塵螨機讓您親眼見證除螨效果!\n" +
                    "    <img\n" +
                    "        src=\"https://lh4.googleusercontent.com/Z6aE0Jl11gAekitgXjmmrf8CaXN03KyA3K04f5IuqgrGSPdO1mAO_6zbu4ynZWXcBwD4ReBU3uKR0T-G7Ozjsw34klU170ZB0SUQm16YdLM7BQ35cczylL8ByIFnRnxije9Q33TGl-SFGjz_Dw\"\n" +
                    "        width=\"189\"\n" +
                    "        height=\"189\"\n" +
                    "    />\n" +
                    "    <img\n" +
                    "        src=\"https://lh4.googleusercontent.com/MAH37HkumEFUNqJFySsgMSVi8LqOI_xqRgzFpUqSz8xC-8NQkIy_kIoPcD8BaDYZRsuzI0I5xaKLuZ-IEJ8318qCAN8fwNwt3mo29gfTGI9tpxdkk5EEZZFK4vpA9Gweeyj0K0mE1Zxf_Tqizg\"\n" +
                    "        width=\"189\"\n" +
                    "        height=\"188\"\n" +
                    "    />\n" +
                    "</p>\n" +
                    "<br/>\n" +
                    "<br/>\n" +
                    "<ol start=\"3\">\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            專業細心管家\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ol>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    專業細心的清潔服務人員，確實執行每一步驟，從枕頭、棉被、床墊、窗簾到冷氣濾網，將清潔效果做到最好。\n" +
                    "</p>\n" +
                    "<br/>\n" +
                    "<img\n" +
                    "    src=\"https://lh6.googleusercontent.com/WXHIfR3dban9ts6FjnTJsstme1UpwwGkxJ69RyRy7hiAztmnlM5Ly8RSboAs0wpKMcLnO4YW2vZumgegDT-ttnAN1-qOxQ3n_M6Sf3__3eT2PJ_qNdipICR0yhmqD1yCnq4b9gDwrNQhut4xfg\"\n" +
                    "    width=\"189\"\n" +
                    "    height=\"189\"\n" +
                    "/>\n" +
                    "<img\n" +
                    "    src=\"https://lh5.googleusercontent.com/2jxPRM8KKvu-I7vxW5sRbEECeoYvDapjypPfC18nI-SXrxjFrvUWJlaMP_Mm_GCGE6v1YDQ9gZotHCB-zlZnbwryIKpUbDwnuYcdOZE08TYtmr1X0HVM-T9l_Lb5_XIAag5NjHnlhOAsL_bCwQ\"\n" +
                    "    width=\"189\"\n" +
                    "    height=\"189\"\n" +
                    "/>\n" +
                    "<br/>\n" +
                    "<br/>";
        }
        Spanned spanned = Html.fromHtml(desc, this, null);
        tvDesc.setText(spanned);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof serviceInformationFragment.OnFragmentInteractionListener) {
            listener = (serviceInformationFragment.OnFragmentInteractionListener) context;
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
    public Drawable getDrawable(String source) {

        LevelListDrawable d = new LevelListDrawable();
        Drawable empty = getResources().getDrawable(R.drawable.selector_primary);
        d.addLevel(0, 0, empty);
        d.setBounds(0, 0, empty.getIntrinsicWidth(), empty.getIntrinsicHeight());
        new LoadImage().execute(source, d);
        return d;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
