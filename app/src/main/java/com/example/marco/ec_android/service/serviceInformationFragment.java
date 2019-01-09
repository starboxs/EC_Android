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

import com.example.marco.ec_android.Conf;
import com.example.marco.ec_android.R;
import com.example.marco.ec_android.api.models.Project;
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
    TextView mTvTitle;
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
        mTvTitle = (TextView) v.findViewById(R.id.textView3);
        mNewsReserviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(serviceInformationFragment.this.getActivity(), serviceStep1Activity.class);
                Project p = Conf.GetProject();
                p.serviceType = mServiceType;
                Conf.setProject(p);
                startActivity(intent);
            }
        });
        Bundle bundle = getArguments();
        if (bundle != null) {
            int item = bundle.getInt("data");
            System.out.println("資料:" + item);
            mServiceType = item + "";
        }
        if (mServiceType.equals("1000")) {
            mTvTitle.setText("居家清潔");
            mNewsReserviceBtn.setText("預約居家清潔");
            desc = "<p dir=\"ltr\">\n" +
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
        } else if (mServiceType.contentEquals("1001")) {
            mNewsReserviceBtn.setText("預約専業除蟎");
            mTvTitle.setText("專業除蟎");
            desc = "<p dir=\"ltr\">\n" +
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
        } else if (mServiceType.contentEquals("1002")) {
            mNewsReserviceBtn.setText("預約水管淨化");
            mTvTitle.setText("水管淨化");
            desc = "<p dir=\"ltr\">\n" +
                    "    水塔定期清洗就可以確保用水衛生了嗎?\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    為何家裡的水管需要清洗呢 ? 自來水管幹內藏有大量大腸桿菌和砷、 汞、鐵、 錳等重金屬及大量泥沙、\n" +
                    "    鐵鏽、泥沙，會隨著管幹流入水塔內，再流入家用水管內！\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    長年沒有清洗水管，很可能積累很多微生物、鐵鏽等雜質，甚至會有水量越來越小，流出有顏色的水等問題。\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    每天刷牙洗臉漱口時，就是使用這樣的水質，您安心嗎?\n" +
                    "</p>\n" +
                    "<br/>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    [簡單自我檢測] 我家該洗水管嗎??\n" +
                    "</p>\n" +
                    "<ul>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            超過兩年沒有洗水管\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            水龍頭流出的水量越來越少\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            熱水器時而點不著或等很久才有熱水\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            清洗過水塔後，水中仍有沉澱物或異味\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            超過一周沒開過水龍頭，使用時有「非透明」的水流出\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ul>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    以上狀況只要超過一個，就應該洗水管啦！\n" +
                    "</p>\n" +
                    "<br/>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    水管淨化必選潔屋大師3大理由\n" +
                    "</p>\n" +
                    "<ol>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            採用食品級檸檬酸，不使用化工原料清洗\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            使用無壓週波清洗設備，沒有洗後漏水的顧慮\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ol>\n" +
                    "<br/>\n" +
                    "<img\n" +
                    "    src=\"https://lh4.googleusercontent.com/r2AwN1OcBFhrm-Drq8OzCPv8H6jQioThfyV3t3-3x1fKRpLxmTZlDwaGhYFvilT73EEun-V1Q9jpj03AyPlit8zUpe9Cz_6FXud2-B64YchX2_gJ2FppjRI1EHyBhv7KtuBqunNK9Df8nQol0g\"\n" +
                    "    width=\"166\"\n" +
                    "    height=\"186\"\n" +
                    "/>\n" +
                    "<img\n" +
                    "    src=\"https://lh5.googleusercontent.com/IKXWlmPp-V009zQJxVHgd8KSdPYEcu2cMnT43hHkXTlbkvJQM3qHq4f0tqBMOct3kJ69QM0Tr5O9VtP7Sik8DnFkj8nN1vz6fNRe2S7rXry5SQa_HY4l0-s7si1JHRc1bEX-VXJtZqOUb4LkPg\"\n" +
                    "    width=\"166\"\n" +
                    "    height=\"186\"\n" +
                    "/>\n" +
                    "<ol start=\"3\">\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            水管淨化效果立見\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ol>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    清洗過程中讓您立即看到清洗效果，完成後會將清洗前、中、後的水質讓客戶立即比較清洗效果。\n" +
                    "</p>\n" +
                    "<br/>\n" +
                    "<img\n" +
                    "    src=\"https://lh3.googleusercontent.com/sKm-25Khi9ets13V9MWaYXPSqHz-AUosMpxf-FjDvdp3mRCN5KXJ02bdrcSziEgmHvuOoNiHaDsiWf62ICyzyA7NL8Fy5bnMAOUm_VXSuy-oUxS8GGmLc64_MkgKZ-73h9DBzkznCJC1YSFwkA\"\n" +
                    "    width=\"189\"\n" +
                    "    height=\"189\"\n" +
                    "/>\n" +
                    "<img\n" +
                    "    src=\"https://lh3.googleusercontent.com/vC0JkaBaGgRJ6FWLmD6G23jcb2UMDaTu57qy3xfg2gpJrGCF5tT9ADm1pwPOujL2-_4lXWq5MW545OAc_Alq4SftIBYfjMqA3sjElWyBc8AYMiyyB9zwCClVPZ2di-HpHNmGJwI95TqqAr5Q_Q\"\n" +
                    "    width=\"189\"\n" +
                    "    height=\"189\"\n" +
                    "/>\n" +
                    "<img\n" +
                    "    src=\"https://lh6.googleusercontent.com/GSR71QuBPIY8LyhbIdR81jtU7RtpJOzt3MwPYl3_8HRyFuAPsOFqK7G2COY4W9Y70CghmEoUBkKd-x2br5fx3KWsVykDy5WDpZEdYGcnL6j_-JIFOQIJhVljVIsQTDE5tlgIIgBO7QVa7qFNdA\"\n" +
                    "    width=\"189\"\n" +
                    "    height=\"189\"\n" +
                    "/>\n" +
                    "</div>";
        } else if (mServiceType.contentEquals("1003")) {
            mNewsReserviceBtn.setText("預約冷氣機清洗");
            mTvTitle.setText("冷氣機清洗");
            desc = "<p dir=\"ltr\">\n" +
                    "    冷氣只洗濾網是遠遠不夠的！冷氣因為使用後機體內部潮濕，會導致空氣中髒污及棉絮纖維混合結塊，成了霉菌、塵螨等各式過敏原的溫床，若不使用藥水、高壓水柱的清洗，加上高溫蒸氣及紫外線的殺菌，不僅冷氣內部會孳生過敏原還會吹出霉味，且冷氣效能大受影響，使用起來不但不夠涼還會相當耗電。\n" +
                    "    <br/>\n" +
                    "</p>\n" +
                    "<br/>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    [簡單自我檢測] 我家冷氣該清洗了嗎??\n" +
                    "</p>\n" +
                    "<ul>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            冷氣不冷\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            冷氣異常耗電\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            開冷氣時有異味/霉味\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            冷氣運轉聲音很大\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "    <li dir=\"ltr\">\n" +
                    "        <p dir=\"ltr\">\n" +
                    "            家人長期過敏\n" +
                    "        </p>\n" +
                    "    </li>\n" +
                    "</ul>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    以上狀況只要超過一個，就應該清洗冷氣啦！\n" +
                    "</p>\n" +
                    "<br/>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    冷氣冷氣4大好處\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    冷-提升冷房效果\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    省-恆溫省電省錢\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    長-延長冷氣壽命\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    靜-降低細菌孳生\n" +
                    "    <img\n" +
                    "        src=\"https://lh4.googleusercontent.com/Cil_XynwVuwWjor-pU5vUlcYsXthJOvvCva7bjX_Xt_XdyLzhrdITDZki0C2fl2QwuF0XXWkNYq0jnPohraeWJjIbzw71VKojaAjc_l1v24YIbeOfFSTK0ht35wKYvMWpqVk-6ch83X50Ae-zw\"\n" +
                    "        width=\"275\"\n" +
                    "        height=\"136\"\n" +
                    "    />\n" +
                    "</p>\n" +
                    "<br/>\n" +
                    "<br/>\n" +
                    "<br/>\n" +
                    "<br/>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    冷氣清洗流程\n" +
                    "</p>\n" +
                    "<p dir=\"ltr\">\n" +
                    "    檢測冷氣效能→進行環境防護→架設集水罩→拆卸外殼水盤→電路保護措施→上清潔劑→機體清洗→防霉處理→組裝還原→環境恢復→檢測驗收\n" +
                    "</p>\n" +
                    "<br/>\n" +
                    "<img\n" +
                    "    src=\"https://lh4.googleusercontent.com/7xzptsoMzU-vY_wXT108_1iBS3GpnCZEtAfdyyrD0XnqYrjvQk3cHuJHlsbq5zXipa3oMD9QCb7H-X0ptjwbK16rxvN81YTWuuJrmPNwgJeeBu9fin9MEtWVqMsFdWc9MzM2R4AsR-1sivTwpA\"\n" +
                    "    width=\"189\"\n" +
                    "    height=\"189\"\n" +
                    "/>\n" +
                    "<img\n" +
                    "    src=\"https://lh4.googleusercontent.com/w4MxnM0RDSv7MM0V72lvIln9hzNMW6yA3EtKo-Nd1NyEDD9l6y4hPnNsQtsdabaMQYkvuMqY8dezlpqb3twoV9kClk-nQLBQkgcKlVdqUYQdFxuKsg4JBqNsY_EVShYJOSJG_gvk_Znaqv-qMQ\"\n" +
                    "    width=\"189\"\n" +
                    "    height=\"189\"\n" +
                    "/>\n" +
                    "<img\n" +
                    "    src=\"https://lh3.googleusercontent.com/mvCC7-vnVp9_XlVkMaAZtMe8YKt954_-dvvxbLwtD8PJi4dczI40KHa8BBYvn9IuHQQUeL1G4sGVKBIB9TBqdXzrJD7SwKcNkhx0V36CXuhiXZpvkwRXztNqZGFUCxcfa7tktY3Wq703xG7KSA\"\n" +
                    "    width=\"189\"\n" +
                    "    height=\"189\"\n" +
                    "/>\n" +
                    "<br/>";
        } else {
            mNewsReserviceBtn.setText("預約洗衣機清洗");
            mTvTitle.setText("洗衣機清洗");
            desc = "<pre id=\"result-source\"><p dir=\"ltr\">清洗好的乾淨衣物上總是會出現小斑點或殘留物嗎？</p><p dir=\"ltr\">洗衣機的運轉聲音越來越大聲嗎？</p><p dir=\"ltr\">烘衣都需烘許久才會乾嗎？</p><p dir=\"ltr\">如果洗衣機使用頻繁或是長久未使用，在悶熱的天氣下，加上洗衣機內部潮濕的環境，很容易產生大量的細菌；原本是將衣物洗乾淨的洗衣機，反而將衣物越洗越髒，而這樣的狀況也可能造成皮膚過敏，或可能對女性帶來婦科疾病的威脅，因此清洗洗衣機內部也是相當重要的，守護您的家人，就從我們身邊的生活小事做起吧！</p><br/><p dir=\"ltr\">[簡單自我檢測] 我家洗衣機該清洗了嗎??</p><ul><li dir=\"ltr\"><p dir=\"ltr\">洗好的衣服有異味/霉味</p></li><li dir=\"ltr\"><p dir=\"ltr\">洗好的衣服有黑點及棉絮</p></li><li dir=\"ltr\"><p dir=\"ltr\">洗衣機運轉聲音很大</p></li><li dir=\"ltr\"><p dir=\"ltr\">家人長期過敏</p></li></ul><p dir=\"ltr\">以上狀況只要超過一個，就應該清洗冷氣啦！</p><br/><p dir=\"ltr\">洗衣機清洗4大好處</p><p dir=\"ltr\">潔-衣服洗得更乾淨</p><p dir=\"ltr\">淨-病毒細菌不要來</p><p dir=\"ltr\">絕-杜絕機體藏汙垢</p><p dir=\"ltr\">健-家人健康少過敏<img src=\"https://lh3.googleusercontent.com/ebnYMCX2JEewb0EPU26EbIzhzuKIvyTvueNdCvhARu1BNoIw6dVvBxgNiK7vjgJo7k3Z6MT7serSTsuT9c4H0M4dBCKYX7M8kB0u76bGHo3UjiRn9xcNXewMrnswl5IG-x4DVzD2u12dbH8aoA\" width=\"261\" height=\"136\"/></p><p dir=\"ltr\">洗衣機清洗流程</p><p dir=\"ltr\">洗衣機運轉檢測→拆卸洗衣機→內桶高壓清洗→洗衣盤清洗→安裝恢復→現場整理 →檢測驗收</p><br/><p dir=\"ltr\">清洗前後比較<img src=\"https://lh3.googleusercontent.com/idiDS6uvaxEqeeibcdxa9Dll758TrndbwaxJ4PoAkrjEYhkbBIskdnuB76t27MGNZDNtZsEZtbDgzrj9JmXHSimXyDtJBZ1XEDfO-YQKjvGai3QFnwYT50JK8nuAOnd75tqEoyPWUIsJJIMoEw\" width=\"188\" height=\"189\"/></p><br/><img src=\"https://lh6.googleusercontent.com/nHOGxHiPKiL5iC-5bbEE2uUxnFj81DIbuG_NGiL-MLCPG1DtpUekQ2eSDpRucc_y0iV09-Pv6a6Clw0AQgXH1l4kpVeKm3WmlLp3PBDKQ0VHwebW5_BmHMj9_lFcAYU1UR32XTRz9E_ZDTzZJg\" width=\"189\" height=\"189\"/><br/><br/><br/><br/><br/><br/><img src=\"https://lh6.googleusercontent.com/15SVgkRZMQNkfDfgeYuZRfxym65Dqzyqlne4vKeEs6tMywIFi75piCwSMP9G9HV4EtoWzF9wZ7Rmd-_RksgGmSJhXBeNAoaDqHFEFh2qu9v5PkiWtsNPOEJNzYmSx2zpEljCFO9i8Iyy1jfwMQ\" width=\"189\" height=\"189\"/><br/><img src=\"https://lh6.googleusercontent.com/9T7Ax3DIUa554ciDdZSEP6rXnNryFyIlQiYDMbavJPcnaXD46-3i7q9c16PGZowhJdb1yGDtEDujmiRLaIeKpd0DT1r_eLhNNbASnE5k3nwUhi9BFqJucg_Pso7WY-lVBt_9tmJYBy8RH-qpIw\" width=\"189\" height=\"189\"/><br/><br/><br/></pre>";
        }


        Spanned spanned = Html.fromHtml(desc, serviceInformationFragment.this, null);
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
