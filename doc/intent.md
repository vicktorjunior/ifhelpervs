# Intent

Um objeto Intent carrega informações que o sistema Android usa para determinar o componente a iniciar 
(como o nome exato do componente ou categoria do componente que deve receber o intent), além de informações 
que o componente receptor usa para realizar a ação adequadamente (como a ação a tomar e os dados a usar).

- Doc Oficial: https://developer.android.com/reference/android/content/Intent.html

| Intent              | Breve descrição | Exemplos de uso  | DOC oficial   | Permissões |
| :-------------------|:---------------:| ----------------:|---------------|
| Abrir navegador     | right-aligned   |  ``` String url = "http://www.example.com";
Intent i = new Intent(Intent.ACTION_VIEW);
i.setData(Uri.parse(url));
startActivity(i);```      |        http....       |   ```xml <android... ```|