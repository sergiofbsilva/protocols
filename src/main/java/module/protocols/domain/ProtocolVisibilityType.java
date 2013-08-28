/**
 * 
 */
package module.protocols.domain;

import pt.ist.bennu.core.i18n.BundleUtil;
import pt.ist.fenixWebFramework.rendererExtensions.util.IPresentableEnum;

/**
 * Defines the level of confidentiality granted to the protocol.
 * 
 * @author Joao Carvalho (joao.pedro.carvalho@ist.utl.pt)
 * 
 */
public enum ProtocolVisibilityType implements IPresentableEnum {

    /**
     * The protocol meta-data will be publicly accessible, but access to the
     * protocol files will be conditioned.
     */
    PROTOCOL,

    /**
     * The protocol meta-data and its files will be accessible only to those
     * specified in the access control list.
     */
    RESTRICTED,

    /**
     * The whole protocol will be accessible to everyone.
     */
    TOTAL;

    @Override
    public String getLocalizedName() {
        return BundleUtil.getString("resources/ProtocolsResources", "label.protocolVisibilityType." + name());
    }

}
