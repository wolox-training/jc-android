package ar.com.wolox.android.training.ui.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/** My <b>LoginFragment</b>. */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements LoginView {

    @BindView(R.id.vLogInButton) Button vLogInButton;
    @BindView(R.id.vSignUpButton) Button vSignUpButton;
    @BindView(R.id.vLogInEmail) EditText vLogInEmail;
    @BindView(R.id.vLogInPassword) EditText vLogInPassword;

    public static final Integer MIN_CHARACTERS_PASSWORD = 6;

    @Override
    public void init() {
        ButterKnife.bind(this, getActivity());
    }

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void setListeners() {
        vLogInButton.setOnClickListener(new View.OnClickListener() {
            @OnClick
            public void onClick(View v) {
                if (vLogInEmail.getText().toString().isEmpty() && vLogInPassword.getText().toString().isEmpty()) {
                    Toast.makeText(requireContext(), "Los campos se encuentran vacíos", Toast.LENGTH_SHORT).show();
                } else if (vLogInEmail.getText().toString().isEmpty()) {
                    Toast.makeText(requireContext(), "Ingrese un correo electrónico", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(vLogInEmail.getText().toString()).matches()) {
                    Toast.makeText(requireContext(), "Ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show();
                } else if (vLogInPassword.getText().toString().isEmpty()) {
                    Toast.makeText(requireContext(), "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                } else if (vLogInPassword.getText().toString().length() < MIN_CHARACTERS_PASSWORD) {
                    Toast.makeText(requireContext(), "La contraseña debe tener más de 6 caracteres", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireContext(), "Login presionado :)", Toast.LENGTH_SHORT).show();
                }
            }
        });

        vSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Sing Up presionado =)", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
