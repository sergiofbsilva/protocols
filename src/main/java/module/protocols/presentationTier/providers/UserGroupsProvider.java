/**
 * 
 */
package module.protocols.presentationTier.providers;

import module.protocols.domain.ProtocolAuthorizationGroup;
import module.protocols.domain.ProtocolManager;
import pt.ist.bennu.core.domain.User;
import pt.ist.bennu.core.security.Authenticate;
import pt.ist.fenixWebFramework.renderers.DataProvider;
import pt.ist.fenixWebFramework.renderers.components.converters.Converter;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

/**
 * @author Joao Carvalho (joao.pedro.carvalho@ist.utl.pt)
 * 
 */
public class UserGroupsProvider implements DataProvider {

    @Override
    public Converter getConverter() {
        return null;
    }

    @Override
    public Object provide(Object arg0, Object arg1) {

        final User user = Authenticate.getUser();

        if (ProtocolManager.getInstance().getAdministrativeGroup().isMember(user)) {
            return ProtocolManager.getInstance().getProtocolAuthorizationGroups();
        }

        return Collections2.filter(ProtocolManager.getInstance().getProtocolAuthorizationGroups(),
                new Predicate<ProtocolAuthorizationGroup>() {

                    @Override
                    public boolean apply(ProtocolAuthorizationGroup group) {

                        return group.getAuthorizedWriterGroup().isMember(user);
                    }
                });
    }
}
