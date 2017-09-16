package ifrs.canoas.lib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ifrs.canoas.ifhelper.R;
import ifrs.canoas.model.portal.Mensagem;

/**
 * Classe Adapter personalizada o android fornece alguns adapters mas que graça tem
 */
public class MensagemAdapter extends BaseAdapter {

    private Context context;//Contexto da aplicação preciso para poder usar os recursos do android
    private List<Mensagem> list; //Minha Lista

    /**
     * Construtor forçando a barra para ter o contexto e uma lista
     *
     * @param context
     * @param list
     */
    public MensagemAdapter(Context context, List<Mensagem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return list.get(arg0).getId();
    }

    @Override
    public View getView(int position, View arg1, ViewGroup arg2) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.mensagem_elemento, null);

        TextView titulo = (TextView) layout.findViewById(R.id.subject);
        final TextView descricao = (TextView) layout.findViewById(R.id.fullmessage);

        final Mensagem mensagem = (Mensagem) this.getItem(position);
        titulo.setText(mensagem.getUserfromfullname());
        String desc = mensagem.getFullmessage().replaceAll("\\<.*?>", "");
        int tam = desc.length() > 100 ? 100 : desc.length();
        final String finalDesc = desc.substring(0, tam);
        descricao.setText(finalDesc);

        Button bt = (Button) layout.findViewById(R.id.messageCompleteDescriptionBT);
        bt.setFocusable(false);
        bt.setFocusableInTouchMode(false);
        bt.setOnClickListener(new View.OnClickListener() {
            private boolean toogle = true;

            @Override
            public void onClick(View view) {
                if (toogle) {
                    descricao.setText(mensagem.getFullmessage().replaceAll("\\<.*?>", ""));
                    toogle = false;
                } else {
                    descricao.setText(finalDesc);
                    toogle = true;
                }
            }
        });

        return layout;
    }

}
