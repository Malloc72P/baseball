import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';

const GlobalStyle = createGlobalStyle`${reset};
/* @font-face {
  font-family: MyHelvetica;
  src: local("Helvetica Neue Bold"),
  local("HelveticaNeue-Bold"),
  url(MgOpenModernaBold.ttf);
  font-weight: bold;
} */

  @import url('https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap');
 
body {
  font-family: 'Press Start 2P', cursive;
  background: linear-gradient(
          rgba(0, 0, 0, 0.7), 
          rgba(0, 0, 0, 0.7)
        ),url('http://localhost:3000/stadium.jpeg') no-repeat;
/* color: white; //text 식별용, 이후 삭제 필요 */
}
`;
export default GlobalStyle;
